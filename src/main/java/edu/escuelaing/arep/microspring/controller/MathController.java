package edu.escuelaing.arep.microspring.controller;

import edu.escuelaing.arep.microspring.GetMapping;
import edu.escuelaing.arep.microspring.RestController;

@RestController
public class MathController {

    @GetMapping("/e")
    public static String e(String notUse){
        return Double.toString(Math.E);
    }

}
