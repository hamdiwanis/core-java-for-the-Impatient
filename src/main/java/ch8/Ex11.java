package ch8;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex11 {
    public static List<String> getMaxLengthWords(Stream<String> words) {
        return words
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(Collections.<String>emptyList());
    }

    public static List<String> wordsOfMaxLength(Stream<String> words, int maxLength) {
        return words.filter(w -> w.length() <= maxLength).collect(Collectors.toList());
    }
}
