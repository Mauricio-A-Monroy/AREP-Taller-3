package edu.escuelaing.arep.microspring;
@RestController
public class MathController {

    @GetMapping("/e")
    public static String e(String notUse){
        return Double.toString(Math.E);
    }

}
