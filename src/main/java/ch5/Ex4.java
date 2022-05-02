package ch5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Missing argument filename");
            return;
        }

        var filename = args[0];

        var result = readValues(filename);

        if (result.error == ReadError.FileNotFound) {
            System.err.println("No file exist with name: " + filename);
        } else {
            System.out.println(result.value);
        }
    }


    public static ReadResult readValues(String filename) {
        var result = new ArrayList<Double>();

        try {
            var fileScanner = new Scanner(new File(filename));

            while (fileScanner.hasNextLine()) {
                var nextValue = fileScanner.nextLine();
                var doubleValue = Double.parseDouble(nextValue);
                result.add(doubleValue);
            }
        } catch (FileNotFoundException e) {
            return ReadResult.ofError(ReadError.FileNotFound);
        }

        return ReadResult.ofValue(result);
    }

    public enum ReadError {FileNotFound}

    public static class ReadResult {
        private final ArrayList<Double> value;

        private final ReadError error;

        public static ReadResult ofValue(ArrayList<Double> value) {
            return new ReadResult(value, null);
        }

        public static ReadResult ofError(ReadError error) {
            return new ReadResult(null, error);
        }

        public ReadResult(ArrayList<Double> value, ReadError error) {
            this.value = value;
            this.error = error;
        }
    }
}
