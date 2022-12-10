package com.platzi.functional._17_operators_collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.platzi.functional._17_operators_collectors.Operators.getCourses;

public class OperacionesTerminales {

    public static void main(String[] args) {
        usoOperacionesTerminalesCoincidencia();
        usoOperacionesTerminalesBusqueda();
        usoOperacionesTerminalesReduccion();
        reduceBinaryAccumulator();
        reducevalorInicialAndBinaryOperator();
        reduceValorInicialBinaryFunctionVTVAndBinaryOperatorV();
        usoCount();
        usoOperacionesTerminalesIteracion();
    }

    private static void usoOperacionesTerminalesIteracion() {
        Stream<List<String>> courses = getCourses(); // Obtiene la lista de cursos en Stream
        courses.forEach(courseList -> System.out.println("Cursos disponibles: " + courseList));
        // Resp ->
        // Cursos disponibles: [Node.js:Intermedio, Express.js:Intermedio, Eventloop:Avanzado]
        // Cursos disponibles: [Spring:Introductorio, Maven:Intermedio, Gradle:Avanzado, Funtional:Introductorio]

        Stream<Integer> infiniteStream = Stream.iterate(0, x -> x + 1);
        List<Integer> numbersList = infiniteStream.limit(30)
                .filter(x -> x % 2 == 0) // Operación intermedia
                .map(x -> x * 3) // Operación intermedia
                .collect(Collectors.toList()); // Operación final (transforma en una lista)

        System.out.println(numbersList); // Resp -> [0, 6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72, 78, 84]
    }

    public List<String> getJavaCourses(Stream<String> coursesStream) {
        List<String> javaCourses = coursesStream.filter(course -> course.contains("Java")).collect(Collectors.toList());
        // Transforma un Stream de strins a una lista de strings con collect(Collectors.toList())
        return javaCourses;
    }
    private static void usoCount() {
        Stream<Integer> yearsStream = Stream.of(1990, 1991, 1994, 2000, 2010, 2019, 2020);
        long yearsCount = yearsStream.count(); // Resp -> 7, solo nos dice cuantos datos tuvo el stream.
        System.out.println(yearsCount);
    }

    private static void reduceValorInicialBinaryFunctionVTVAndBinaryOperatorV() {
        // No hace la rediucion correctamente
        Stream<String> aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        int charCount = aLongStoryStreamAgain.reduce(0, (count, word) -> count + word.trim().length(), Integer::sum);
        System.out.println(charCount); // Resp -> 48 total de caracteres
        // 6 + 9 + 2 + 10 + 7 + 6 + 5 = 45
    }

    private static void reducevalorInicialAndBinaryOperator() {
        Stream<Integer> firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(10);
        int sumOfFirstTen = firstTenNumbersStream.reduce(0, Integer::sum); // 45 -> 0 + 1 + … + 9
        System.out.println(sumOfFirstTen); // Resp -> 45 ya que es la suma de cada elemento sumando
    }

    private static void reduceBinaryAccumulator() {
        Stream<String> aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        Optional<String> longStoryOptional = aLongStoryStream.reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
        longStoryOptional.ifPresent(System.out::println); //"Cuando despertó, el dinosaurio todavía estaba allí."
    }

    private static void usoOperacionesTerminalesReduccion() {
        // Encuentra el valor minimo de un arreglo
        Stream<Long> bigNumbers = Stream.of(100L, 200L, 1000L, 5L);
        Optional<Long> minimumOptional = bigNumbers.min((numberX, numberY) -> (int) Math.min(numberX, numberY));
        System.out.println(minimumOptional.get()); // Resp -> 5

        // Encuentra el valor maximo de un arreglo
        Stream<Integer> bigNumbers2 = Stream.of(100, 200, 1000, 5);
        Optional<Integer> maxOptional2 = bigNumbers2.max(Comparator.comparingInt(a -> a));
        System.out.println(maxOptional2.get()); // Resp -> 1000
    }

    private static void usoOperacionesTerminalesBusqueda() {
        // finFirst() encuentra el primer elemento
        Stream<Integer> numbersStream = Stream.of(5);
        Optional<Integer> findNumber = numbersStream.findFirst();
        System.out.println(findNumber.get());

        // findAny si existen datos en el stream
        Stream<Integer> numbersStream2 = Stream.of(5, 2, 7, 8);
        Optional<Integer> findNumber2 = numbersStream2.filter(x -> x == 2).findAny();
        findNumber2.ifPresent(System.out::println);
    }

    private static void usoOperacionesTerminalesCoincidencia() {
        // anyMatch
        // Nos indica si un stream contiene un elemento según el Predicate que le pasemos:
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 11);
        boolean biggerThanTen = numbersStream.anyMatch(i -> i > 10); // true porque tenemos el 11

        // allMatch
        // Nos indica si todos los elementos de un Stream cumplen con un cierto Predicate:
        Stream<Integer> agesStream = Stream.of(19, 21, 35, 45, 12);
        boolean allLegalDrinkingAge = agesStream.allMatch(age -> age > 18); // false, tenemos uno menor

        // noneMatch
        // Nos indica si todos los elementos de un Stream NO CUMPLEN un cierto Predicate:
        Stream<Integer> oddNumbers = Stream.of(1, 3, 5, 7, 9, 11);
        boolean allAreOdd = oddNumbers.noneMatch(i -> i % 2 == 0); // true, no todos cumplen
    }

}
