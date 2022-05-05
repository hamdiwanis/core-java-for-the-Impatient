package ch8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex10 {
    public static double getAverageWordLength(Stream<String> words) {
        return words.collect(Collectors.summarizingInt(String::length)).getAverage();
    }
}
