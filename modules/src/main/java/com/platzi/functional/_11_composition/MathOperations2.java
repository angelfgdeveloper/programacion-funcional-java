package com.platzi.functional._11_composition;

import java.util.function.Function;

public class MathOperations2 {

    public static void main(String[] args) {
        Function<Integer, Integer> multiplyBy3 = x -> x * 3;

        // funcion compuesta
        // componse -> ejecuta una funcion primero y despues ejecuta la funcion a la cual se esta llamando
        Function<Integer, Integer> addOneMuliplyBy3 = multiplyBy3.compose(y -> {
            System.out.println("Le agregare 1 a: " + y);
            return y + 1;
        });

        // andThen -> se ejecuta despues de que sea hayan terminado las funciones anteriores
        Function<Integer, Integer> andSquare =
                addOneMuliplyBy3.andThen(x -> {
                    System.out.println("Estoy elevando " + x + " al cuadrado");
                    return x * x;
                });

        System.out.println(addOneMuliplyBy3.apply(5));
        // Resp -> Le agregare 1 a: 5
        // Resp -> 18

        System.out.println(andSquare.apply(3));
        // Resp -> Estoy elevando 12 al cuadrado
        // Resp -> 144
    }

}
