package ch5;

import java.io.FileNotFoundException;

public class Ex2 {
    public static double sumOfValues(String filename) throws FileNotFoundException, NumberFormatException {
        double sum = 0.0;
        var list = Ex1.readValues(filename);

        for (var value : list) {
            sum += value;
        }

        return sum;
    }
}
