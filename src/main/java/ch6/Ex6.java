package ch6;

import java.util.ArrayList;

public class Ex6 {
    public static void main(String[] args) {
        var listOfPersons = new ArrayList<Person>();
        var listOfStudents = new ArrayList<Student>();

        // works
        appendsAll1(listOfStudents, listOfPersons);
        appendsAll2(listOfStudents, listOfPersons);

        // does not work
        // appendsAll1(listOfPersons, listOfStudents);
        // appendsAll2(listOfPersons, listOfStudents);
    }

    public static class Person {
    }

    public static class Student extends Person {
    }


    public static <T> void appendsAll1(ArrayList<? extends T> from, ArrayList<T> to) {
        to.addAll(from);
    }

    public static <T> void appendsAll2(ArrayList<T> from, ArrayList<? super T> to) {
        to.addAll(from);
    }
}
