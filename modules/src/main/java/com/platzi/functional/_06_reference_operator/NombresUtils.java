package com.platzi.functional._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {

    public static void main(String[] args) {
        List<String> profesores = getList("Luis", "Angel", "Evelyn");

        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        System.out.println("////////");
        profesores.forEach(System.out::println); // :: (operador) -> busca este metodo
    }

    // Generar lista y retornala
    static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }

}
