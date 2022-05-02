package ch5;

import java.io.FileNotFoundException;

public class Ex3 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Missing argument filename");
            return;
        }

        var filename = args[0];

        try {
            var result = Ex2.sumOfValues(filename);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            System.err.println("No file exist with name: " + filename);
        } catch (NumberFormatException e) {
            System.err.println("File must contain double values only");
        }
    }
}
