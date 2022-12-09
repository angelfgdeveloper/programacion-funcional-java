package com.platzi.functional._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {
    // SAM -> Single abstract method
//    @FunctionalInterface
//    interface BiConsumer {
//        void accept();
////        int accept2(); // no lo permite
//    }

    public static void main(String[] args) {
        // Para añadirle 0 si es menor a 10 = 09, 05 etc. en String
        Function<Integer, String> addCero = x -> x < 10 ? "0" + x : String.valueOf(x);

        // LocalDate -> Fecha
        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(
                        year + "-" + addCero.apply(month) + "-" + addCero.apply(day)
                );

        // Calcula los datos entre ahora y nuestra fecha
        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day, month, year),
                        LocalDate.now()
                ).getYears();

        // day, month, year
        System.out.println(calculateAge.apply(10, 12, 1994)); // Resp -> 27
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
