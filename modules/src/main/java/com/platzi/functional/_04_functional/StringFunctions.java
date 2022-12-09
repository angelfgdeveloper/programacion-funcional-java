package com.platzi.functional._04_functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {

    public static void main(String[] args) {
        // Para manipular informacion
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        System.out.println(quote.apply("Hola estudiante de Platzi!")); // Resp -> "Hola estudiante de Platzi!"

        UnaryOperator<String> addMark = text -> text + "!";
        System.out.println(addMark.apply("HOLA")); // Resp -> HOLA!

        // Solo admite dos paramentros
        //Function<String, String> ag = x -> x

        // Admite mas de dos paramentros
        BiFunction<Integer, Integer, Integer> multiplicacion = (x, y) -> x * y;
        System.out.println(multiplicacion.apply(5, 4)); // Resp -> 20

        // Lo que pide es del mismo tipo (2 parametros) y devuelve un tercero resp. que es del mismo tipo
        BinaryOperator<Integer> multi = (x, y) -> x * y;
        System.out.println(multiplicacion.apply(10, 10)); // Resp -> 100

        // Formatear con s -> espacios
        BiFunction<String, Integer, String> leftPad = (text, number) -> String.format("%" + number + "s", text);
        System.out.println(leftPad.apply("Java", 10)); // Resp ->          Java

        List<BiFunction<String, Integer, String>> formateadores = new ArrayList<>();
    }

}
