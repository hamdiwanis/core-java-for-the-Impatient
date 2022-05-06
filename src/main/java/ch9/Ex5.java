package ch9;

import java.util.List;

import static java.nio.charset.StandardCharsets.*;

public class Ex5 {
    public static void main(String[] args) {
        var charsets = List.of(US_ASCII, UTF_8, UTF_16, ISO_8859_1);
        for (var charset : charsets) {
            var replacement = charset.newEncoder().replacement();

            System.out.print(charset.name() + " : ");

            for (var b : replacement) {
                System.out.print((char) b);
            }

            System.out.println();
        }
    }
}
