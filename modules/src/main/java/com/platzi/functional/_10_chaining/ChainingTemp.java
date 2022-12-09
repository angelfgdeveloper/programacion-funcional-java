package com.platzi.functional._10_chaining;

public class ChainingTemp {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hola")
                .append("Alumno")
                .append("de")
                .append("Platzi");

        // Ha esto se le llama chaining
        Chainer chainer = new Chainer();

        Chainer chainer2 = chainer.sayHi();
        Chainer chainer3 = chainer2.sayBye();

        chainer.sayHi().sayBye(); // Internamente esta llamando y regresando el mismo objeto

        // Funciones de orden mayor
        // Es una funcion o toma como parametro otra funcion o devuelve una funcion o las dos
        // Genera composicion de funciones
    }

    static class Chainer {
        public Chainer sayHi() {
            System.out.println("Hola");
            return this; // Devolver esta misma instancia
        }

        public Chainer sayBye() {
            System.out.println("Bye");
            return this;
        }
    }
}
