package ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex6 {
    public static void main(String[] args) {
        // (a) catching the exception in the finally clause.
        {
            BufferedReader in = null;
            try {
                in = Files.newBufferedReader(Path.of("path"), StandardCharsets.UTF_8);
                // read
            } catch (IOException ex) {
                System.err.println("Caught IOException: " + ex.getMessage());
            } finally {
                if (in != null) {
                    try {
                        in.close(); // Caution—might throw an exception
                    } catch (IOException ex) {
                        System.err.println("Caught IOException: " + ex.getMessage());
                    }
                }
            }
        }

        // (b) a try/catch statement containing a try/finally statement.
        {
            BufferedReader in = null;
            try {
                try {
                    in = Files.newBufferedReader(Path.of("path"), StandardCharsets.UTF_8);
                    // read
                } finally {
                    if (in != null) {
                        in.close(); // Caution—might throw an exception
                    }
                }
            } catch (IOException ex) {
                System.err.println("Caught IOException: " + ex.getMessage());
            }
        }

        // (c) a try-with-resources statement with a catch clause.
        {
            try (BufferedReader in = Files.newBufferedReader(Path.of("path"), StandardCharsets.UTF_8)) {
                // read
            } catch (IOException ex) {
                System.err.println("Caught IOException: " + ex.getMessage());
            }
        }
    }
}
