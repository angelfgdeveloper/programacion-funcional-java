package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
// import java.util.Optional;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<String> courseList = NombresUtils.getList(
                "Java",
                "FrontEnd",
                "Backend",
                "FullStack"
        );

        // Forma normal de usar arreglos
        for (String course : courseList) {
            String newCourseName = course.toLowerCase().replace("!", "!!");
            System.out.println("Platzi: " + newCourseName);
        }

        /** USO DE STREAM **/
        // Stream solo se utiliza una vez, no se puede consumir de nuevo
        Stream<String> coursesStream = Stream.of(
                "Java",
                "FrontEnd",
                "Backend",
                "FullStack"
        );

        // Stream<Integer> courseLengthStream = coursesStream.map(course -> course.length()); // nuevo arreglo de numeros
        // Optional<Integer> longest = courseLengthStream.max((x, y) -> y - x); // Devuelve el mas grande

        Stream<String> empthasisCourses = coursesStream.map(course -> course + "!");
        Stream<String> justJavaCourses = empthasisCourses.filter(course -> course.contains("Java")); // un arreglo filtrado
        justJavaCourses.forEach(System.out::println);

        Stream<String> coursesStream2 = courseList.stream(); // Generar un stream
        // coursesStream2.map(course -> course + "!!")
        //         .filter(course -> course.contains("Java"))
        //         .forEach(System.out::println); // Resp -> Java!!

        // Si te devuelve un String es una operacion INTERMEDIA
        // Si te devuelve cualquier otro tipo de datoo o no es una operacion FINAL

         addOperator(
                 coursesStream2.map(course -> course + "!!").filter(course -> course.contains("Java"))
         ).forEach(System.out::println); // Resp -> Java!!
    }

    static <T> Stream<T> addOperator(Stream<T> stream) {
        // peek -> itera sobre los datos sin modificar o alterar el stram
        return stream.peek(data -> System.out.println("Dato: " + data)); // Dato: Java!!
    }

}
