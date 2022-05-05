package ch8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println(codePoints("HÄMD\uD83C\uDF53Î").collect(Collectors.toList()));
    }

    public static Stream<String> codePoints(String s) {
        int len = s.codePointCount(0, s.length());

        return IntStream
                .iterate(0, i -> i <= len, i -> s.offsetByCodePoints(i, 1))
                .mapToObj(offset -> s.substring(offset, s.offsetByCodePoints(offset, 1)));
    }
}
