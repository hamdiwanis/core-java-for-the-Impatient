package ch9;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex1 {
    public static void main(String[] args) {
        try (
                var in = Files.newInputStream(Path.of("in.txt"));
                var out = Files.newOutputStream(Path.of("out.txt"))
        ) {
            copyInputStream(in, out);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void copyInputStream(InputStream from, OutputStream to) throws IOException {
        from.transferTo(to);
    }
}
