package edu.escuelaing.arep.microspring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MicroServer {

    public static Map<String, Method> services = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        loadComponents(args);
        System.out.println(simulateRequests("/greeting") + "\n");
        System.out.println(simulateRequests("/pi") + "\n");
        System.out.println(simulateRequests("/e") + "\n");
    }

    private static void loadComponents(String[] args) throws ClassNotFoundException {
        for(String arg: args){
            Class c = Class.forName(arg);
            if (!c.isAnnotationPresent(RestController.class)) {
                System.exit(0);
            }
            for (Method mtd : c.getDeclaredMethods()) {
                if (mtd.isAnnotationPresent(GetMapping.class)) {
                    GetMapping a = mtd.getAnnotation(GetMapping.class);
                    services.put(a.value(), mtd);
                }
            }
        }
    }

    private static String simulateRequests(String route) throws InvocationTargetException, IllegalAccessException {
        Method mtd = services.get(route);
        String response = "HTTP/1.1 201 Created\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\"response\":" + mtd.invoke(null, "Alejo") + "\"}";

        return response;
    }
}
