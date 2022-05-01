package ch3;

public class Ex1 {
    public static double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable object : objects) {
            sum += object.getMeasure();
        }

        return sum / objects.length;
    }


    public interface Measurable {
        double getMeasure();
    }

    public static class Employee implements Measurable {
        private final String name;
        private final double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public double getMeasure() {
            return this.salary;
        }
    }
}
