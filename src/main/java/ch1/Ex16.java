package ch1;

public class Ex16 {
    public static double average(double num, double... rest) {
        double sum = num;

        for (double number : rest) {
            sum += number;
        }

        return sum / (rest.length + 1);
    }
}
