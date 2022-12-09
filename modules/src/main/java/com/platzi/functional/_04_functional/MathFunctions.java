package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {

    public static void main(String[] args) {
        // Funcion del cuadrado de un número
        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        System.out.println(squareFunction.apply(5)); // Resp -> 25
        System.out.println(squareFunction.apply(25)); // Resp -> 625
        System.out.println(square(10)); // Resp -> 100

        // Es impar con lambda
        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;
        System.out.println(isOdd.apply(3)); // Resp -> es impar true

        // Revisar si un predicado es verdad (es par)
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4)); // Resp -> true

        // Revisa si el Student pasa la calificacion (mayor a 6.0)
        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6.0;
        Student sinude = new Student(5.9); // Calificacion de Student
        System.out.println(isApproved.test(sinude)); // Resp -> false
    }

    // Funcion static del cuadrado de un número
    static int square(int x) {
        return x * x;
    }

    static class Student {
        private double calificacion;

        public Student(double calificacion) {
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }
    }

}
