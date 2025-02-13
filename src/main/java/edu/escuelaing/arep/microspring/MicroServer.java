package edu.escuelaing.arep.microspring;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MicroServer {

    public static Map<String, Method> services = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        List<String> classNames = getClassesInPackage("edu.escuelaing.arep.microspring.controller");

        loadComponents(classNames.toArray(new String[0]));
        System.out.println(simulateRequests("/greeting"));
        System.out.println(simulateRequests("/pi") + "\n");
        System.out.println(simulateRequests("/e") + "\n");
    }

    public static List<String> getClassesInPackage(String packageName) throws ClassNotFoundException {
        List<String> classNames = new ArrayList<>();
        String path = packageName.replace('.', '/');
        URL packageURL = Thread.currentThread().getContextClassLoader().getResource(path);

        if (packageURL != null) {
            File directory = new File(packageURL.getFile());
            if (directory.exists()) {
                for (String fileName : directory.list()) {
                    if (fileName.endsWith(".class")) {
                        String className = packageName + "." + fileName.substring(0, fileName.length() - 6);
                        classNames.add(className);
                    }
                }
            }
        }

        return classNames;
    }

    private static void loadComponents(String[] args) throws ClassNotFoundException {
        System.out.println(args[0]);
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
