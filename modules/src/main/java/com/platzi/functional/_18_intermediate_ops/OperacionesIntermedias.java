package com.platzi.functional._18_intermediate_ops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class OperacionesIntermedias {

    public static void main(String[] args) {
        operacionesIntermedias();
        getJavaCourses(Arrays.asList("Javascript", "Java", "Csharp", "Typescript"));
//        Stream<DatabaseID> ids = DatabaseUtils.getIds().stream();
//        Stream<User> users = ids.map(id -> db.getUserWithId(id));

        flapMap();
        peek();
        skip();
    }

    private static void skip() {
        /**
         * Mientras limit() reduce los elementos presentes en el Stream a un numero especifico, skip descarta
         * los primeros n elementos y genera un Stream con los elementos restantes en el Stream.
         * **/
        Stream<Integer> first10Numbers = Stream.of(0,1,2,3,4,5,6,7,8,9);
        Stream<Integer> last7Numbers = first10Numbers.skip(3); // 3,4,5,6,7,8,9
    }

    private static void peek() {
        // Lo que hace esta operación es tomar un Consumer,
        // pasar los datos conforme van estando presentes en el Stream y generar un nuevo
        // Stream idéntico para poder seguir operando.

//        Stream<Connection> serverConnections =
//                server.getConnectionsStream()
//                        .peek(connection -> logConnection(connection, new Date()))
//                        .filter(…)
//                        .map(…)
        //Otras operaciones…
    }

    private static void flapMap() {
        Stream<List<Courses>> coursesLists; // Stream{List["Java", "Java 8 Functional", "Spring"], List["React", "Angular", "Vue.js"], List["Big Data", "Pandas"]}
        Stream<Courses> allCourses; // Stream{ ["Java", "Java 8 Functional", "Spring", "React", "Angular", "Vue.js", "Big Data", "Pandas"]}

        //Primero obtenemos objetos de tipo usuario registrados en Platzi:
        Stream<PlatziStudent> platziStudents = getPlatziUsers(); //.stream();

        // Despues, queremos enviarle un correo a todos los usuarios pero…
        // solo nos interesa obtener su correo para notificarlos:
        Stream<Email> allEmailsToNotify =
                platziStudents.filter(PlatziStudent::isEmailSubscribed) //Primero evitamos enviar correos a quienes no estén subscritos
                        .flatMap(student -> student.getEmails().stream()); // La lambda genera un nuevo Stream de la lista de emails de cada studiante.

        //sendMonthlyEmails(allEmailsToNotify);
        //El Stream final solo es un Stream de emails, sin mas detalles ni información adicional.
    }

    private static Stream<PlatziStudent> getPlatziUsers() {
        return new LinkedList<PlatziStudent>().stream();
    }


//    public static Stream<String> getJavaCoursesConPredicates(List<String> courses){
//        return courses.filter(Predicates::isAJavaCourse)
//                .filter(Predicates::hasEnoughDuration)
//                .filter(Predicates::hasSinuheAsInstructor);
//    }

//    private static void filtradosAnidadosStream() {
//        return courses.filter(course -> course.getName().contains("Java"))
//                .filter(course -> course.getDuration() > 2.5)
//                .filter(course -> course.getInstructor().getName() == Instructors.SINUHE_JAIME)
//    }

    public static Stream<String> getJavaCourses(List<String> courses){
        return courses.stream().filter(course -> course.contains("Java"));
    }

    /**
     * Se le dice operación intermedia a toda operación dentro de un Stream que como resultado devuelva un nuevo Stream.
     * Es decir, tras invocar una operación intermedia con un cierto tipo de dato,
     * obtendremos como resultado un nuevo Stream conteniendo los datos ya modificados.
     * **/
    private static void operacionesIntermedias() {
        Stream<String> initialCourses = Stream.of("Java", "Spring", "Node.js");

        Stream<Integer> lettersOnCourses = initialCourses.map(course -> course.length());
        //De este punto en adelante, initialCourses ya no puede agregar mas operaciones.

        Stream<Integer> evenLengthCourses = lettersOnCourses.filter(courseLength -> courseLength % 2 == 0);
        //lettersOnCourses se consume en este punto y ya no puede agregar mas operaciones.
        // No es posible usar el Stream mas que como referencia.
    }


    // La lógica es la misma:
    public final class Predicates {
        public final boolean isAJavaCourse(Course course){
            return course.getName().contains("Java");
        }
    }

    //Tenemos esta clase:
    public class PlatziStudent {
        private boolean emailSubscribed;
        private List<Email> emails;

        public boolean isEmailSubscribed() {
            return emailSubscribed;
        }

        public List<Email> getEmails(){
            return new LinkedList<>(emails); //Creamos una copia de la lista para mantener la clase inmutable por seguridad
        }
    }
}
