package ch3;

import java.util.Arrays;
import java.util.Comparator;

public class Ex15 {
    public static class Employee {
        private final String name;
        private final double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void sortEmployees(Employee[] employees, boolean isReversed) {
        var comparator = Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName);

        if (isReversed) {
            comparator = comparator.reversed();
        }

        Arrays.sort(employees, comparator);
    }
}
