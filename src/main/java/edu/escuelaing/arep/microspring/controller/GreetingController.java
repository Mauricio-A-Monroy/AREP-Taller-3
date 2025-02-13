package edu.escuelaing.arep.microspring.controller;

import edu.escuelaing.arep.microspring.GetMapping;
import edu.escuelaing.arep.microspring.RequestParam;
import edu.escuelaing.arep.microspring.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public static String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hola " + name;
    }

    @GetMapping("/pi")
    public static String pi(@RequestParam(value = "name", defaultValue = "World") String name) {
        return Double.toString(Math.PI);
    }
}