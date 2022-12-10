package com.platzi.functional._17_operators_collectors;

import com.platzi.functional.util.Utils;

// import java.util.function.Predicate;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperatorsAndCollectors {

    public static void main(String[] args) {
        Stream<String> coursesStream = Utils.getListOf("Java", "Node.js", "Kotlin").stream();
        Stream<String> javaCoursesStream = coursesStream.filter(course -> course.contains("Java"));

        // En realidad, es lo mismo que:
        // Stream<String> explicitOperationStream = coursesStream.filter(new Predicate<String>() {
        //     public boolean test(String st) {
        //         return st.contains("Java");
        //     }
        // });

        // Consumer<T>: recibe un dato de tipo T y no genera ningún resultado
        // Function<T,R>: toma un dato de tipo T y genera un resultado de tipo R
        // Predicate<T>: toma un dato de tipo T y evalúa si el dato cumple una condición
        // Supplier<T>: no recibe ningún dato, pero genera un dato de tipo T cada vez que es invocado
        // UnaryOperator<T> recibe un dato de tipo T y genera un resultado de tipo T
    }

    public List<String> getJavaCourses(Stream<String> coursesStream) {
        List<String> javaCourses = coursesStream.filter(course -> course.contains("Java"))
                        .collect(Collectors.toList()); // Convierte de un Stream a una lista

        return javaCourses;
    }

    public static abstract class PlatziStream<T> implements Stream {
        private List<T> data;

        public Stream<T> filter(Predicate predicate) {
            List<T> filteredData = new LinkedList<>();
            for(T t : data){
                if(predicate.test(t)){
                    filteredData.add(t);
                }
            }

            return filteredData.stream();
        }
    }

}
