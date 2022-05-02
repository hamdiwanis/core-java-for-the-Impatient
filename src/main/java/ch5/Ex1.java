package ch5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {
    public static ArrayList<Double> readValues(String filename) throws FileNotFoundException, NumberFormatException {
        var result = new ArrayList<Double>();
        var fileScanner = new Scanner(new File(filename));
        
        while (fileScanner.hasNextLine()) {
            var nextValue = fileScanner.nextLine();
            var doubleValue = Double.parseDouble(nextValue);
            result.add(doubleValue);
        }

        return result;
    }
}
