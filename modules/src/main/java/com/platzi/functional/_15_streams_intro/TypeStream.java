package com.platzi.functional._15_streams_intro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TypeStream {

    public static void main(String[] args) {
        // Generando datos infinitos y limitarlos
        // Iniciamos en 0, y sumamos en uno
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        infiniteStream.limit(1000) // Hasta mil
                .parallel() // Va regresando los resultados con forme van terminando (cuando no importa el orden de los datos)
                .filter(x -> x % 2 == 0) // Los filtra por datos pares
                //.allMatch(x -> ) // funcion que retorna un boolean (Verifica que todos los valores sean validos)
                .forEach(System.out::println); // Resp -> 0, 2, 4, 6 ...etc. hasta 998

        getListNumbers();
    }

    private static void getListNumbers() {
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        List<Integer> numberList = infiniteStream.limit(1000) // Hasta mil
                .parallel() // Va regresando los resultados con forme van terminando (cuando no importa el orden de los datos)
                .filter(x -> x % 2 == 0) // Los filtra por datos pares
                //.allMatch(x -> ) // funcion que retorna un boolean (Verifica que todos los valores sean validos)
                .boxed() // Convertir en un Stream de enteros
                .collect(Collectors.toList()); // Construir un stream a una lista, o mapa, arreglot, etc,

        // Collectors.toList() => Convierte a una lista
        // Collectors.toCollection() => Permite generar una collection de datos
        // Collectors.toConcurrentMap() => Para convertir un mapa concurrente para paralelismo o concurrencia
        // Collectors.toMap() => Convierte a un map con una funcion
        // Collectors.toSet() => Para hacer elementos unicos
    }

}
