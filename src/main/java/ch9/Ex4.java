package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) throws IOException {
        var filePath = "test.text";

        {
            int noOfLines = 0;
            try (var in = new Scanner(filePath)) {
                while (in.hasNextLine()) {
                    noOfLines++;
                    in.nextLine();
                }
            }
        }

        // fastest
        {
            int noOfLines = 0;
            try (var in = new BufferedReader(Files.newBufferedReader(Path.of(filePath)))) {
                var line = in.readLine();
                while (line != null) {
                    noOfLines++;
                    line = in.readLine();
                }
            }
        }

        // most convenient
        {
            long noOfLines = 0;
            try (var in = Files.newBufferedReader(Path.of(filePath))) {
                noOfLines = in.lines().count();
            }
        }
    }
}
