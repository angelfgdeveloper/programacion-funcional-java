package com.platzi.functional._09_defaults;

public class StringFunctions {

    @FunctionalInterface
    interface StringOperation {
        int getAmount();
        default void operate(String text) {
            int x = getAmount();
            while (x-- > 0) {
                System.out.println(text);
            }
        }
    }

    @FunctionalInterface
    interface DoOperation {
        void take(String text);
        default void execute(int x, String text) {
            while (x-- > 0) {
                take(text);
            }
        }
    }

    public static void main(String[] args) {
        StringOperation six = () -> 6; // Agregamos el amount 6
        six.operate("Alumno"); // Imprime 6 veces el text Almuno

        DoOperation operateFive = text -> System.out.println(text); // Se imprime el texto
        operateFive.execute(5,"Platzi"); // Ejecuta el metodo, el numero de veces y el texto
    }

}
