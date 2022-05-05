package ch8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {
        var longestWords = Stream.of("A", "ABCD", "EFGH", "JKLMN", "X", "XYZQ")
                .peek(s -> System.out.println("@Processing: " + s))
                .filter(s -> s.length() > 3)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("@Result: " + longestWords);
    }
}
