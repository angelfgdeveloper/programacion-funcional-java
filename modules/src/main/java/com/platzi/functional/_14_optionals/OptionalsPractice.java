package com.platzi.functional._14_optionals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalsPractice {

    /**
     * Optionals -> operar con un dato cuando este presente o no este presente
     * **/
    public static void main(String[] args) {
        List<String> names = getNames();
        if (names != null) {
            // Operar con nombres
        }

        // Con optionals
        Optional<List<String>> optionalNames = getOptionalNames();
        if (optionalNames.isPresent()) { // Si esta prensente hacemos ...
            // code ..
        }

        // Aqui valida si esta presente
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        // flapMap consume una funcion y un optional
        // optionalNames.flatMap();
        // Genera un optional de un nuevo tipo, este o no presente
        // MONA previente lo de datos vacios
        // optionalNames.map();

        // Optional para no preocuparnos por los nulos, vacios,y retornar valores default
        Optional<String> valuablePlayer = optionalMostValueblePlayer();
        String valueablePlayer = valuablePlayer.orElseGet(() -> "No player");
    }

    static List<String> getNames() {
        List<String> list = new LinkedList<>();
        return Collections.emptyList(); // Regresar una collection sin elementos
    }

    static String mostValueblePlayer() {
        // return "";
        return null;
    }

    static int mostExpensiveItem() {
        return -1;
    }

    /** OPTIONAL FUNCTION STATICS **/
    static Optional<List<String>> getOptionalNames() {
        // return Optional.of(new LinkedList<>());
        List<String> namesList = new LinkedList<>();
        // obtencion de nombres

        return Optional.of(namesList);
    }
    static Optional<String> optionalMostValueblePlayer() {
        // Dato del cual desconocemos si es nulo
        // return Optional.ofNullable("Angel");

        try {
            // Acceso
            return Optional.of("Luis"); // Retornar dato que existe
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty(); // Retornar vacio
    }

}
