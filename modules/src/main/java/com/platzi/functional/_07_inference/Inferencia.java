package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.Function;

public class Inferencia {

    public static void main(String[] args) {
        // Inferencia de tipos
        // Java se encarga de validar que sean del tipo, adivina que tipo de dato genera o refresa
        Function<Integer, String> funcionConvertidora = integer -> "Al doble: " + (integer * 2);

        List<String> alumnos = NombresUtils.getList("Evely", "Luis", "Paty");
        alumnos.forEach((String name) -> System.out.println(name)); // #1
        System.out.println("/////////");
        alumnos.forEach(name -> System.out.println(name)); // #2
        System.out.println("/////////");
        alumnos.forEach(System.out::println); // #3
    }

}
