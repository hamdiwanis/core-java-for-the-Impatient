package ch3;

public class Ex1 {
    public static double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable object : objects) {
            sum += object.getMeasure();
        }

        return sum / objects.length;
    }

    public static Measurable largest(Measurable[] objects) {
        if (objects.length < 1) {
            return null;
        }

        Measurable max = objects[0];
        for (Measurable object : objects) {
            if (object.getMeasure() > max.getMeasure()) {
                max = object;
            }
        }

        return max;
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

        public String getName() {
            return name;
        }

        @Override
        public double getMeasure() {
            return this.salary;
        }
    }
}
