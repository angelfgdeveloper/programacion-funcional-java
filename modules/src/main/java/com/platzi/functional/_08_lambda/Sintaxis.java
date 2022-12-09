package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {

    public static void main(String[] args) {
        List<String> cursos = NombresUtils.getList("Java", "Functional");

        // Lambda -> (Son para casos unicos)
        cursos.forEach(curso -> System.out.println(curso));
        // BiFunction<Integer, Integer, Integer> s = (x, y) -> x * y;

        // () inicia nuestra lambda vacia -> A donde va 2 lo que va a realizar
        usarZero(() -> 2);

        // Necesita devolver un boolean (con argumento)
        usarPredicado(text -> text.isEmpty());

        // Lambda que representa una bifunction (con dos argumentos)
        usarBiFunction((x, y) -> x * y);

        usarBiFunction((x, y) -> {
            System.out.println("X: " + x + ", Y: " + y);
            return x - y; // Java necesita saber donde retorna
        });

        // funcion que no no recibe ningun dato y que no regresa ningun dato
        usarNada(() -> {});
        usarNada(() -> {
            System.out.println("Hola Alumno");
        });

        usarBiFunction((Integer x, Integer y) -> x * y); // Agregar el tipo de dato explicito
    }

    static void usarZero(ZeroArgumentos zeroArgumentos) {

    }

    static void usarPredicado(Predicate<String> predicado) {

    }

    static void usarBiFunction(BiFunction<Integer, Integer, Integer> operacion) {

    }

    static void usarNada(OperarNada operarNada) {

    }

    @FunctionalInterface
    interface ZeroArgumentos {
        int get(); // No recibe ningun dato
    }

    @FunctionalInterface
    interface OperarNada {
        void nada();
    }

}
