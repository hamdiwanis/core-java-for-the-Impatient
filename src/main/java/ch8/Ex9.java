package ch8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import static java.util.stream.Collectors.toConcurrentMap;
import static java.util.stream.Collectors.toList;

public class Ex9 {
    public static List<String> wordsContainingNDistinctVowels(String filePath, int n) throws FileNotFoundException {
        final var VOWELS = List.of('a', 'e', 'i', 'o', 'u');

        Function<String, Long> countDistinctVowels = w -> {
            return w.chars().filter(c -> VOWELS.contains((char) c)).distinct().count();
        };

        var in = new Scanner(new File(filePath));
        in.useDelimiter("\\PL+");

        var wordVowelsCountMap = in.tokens().parallel().unordered()
                .collect(toConcurrentMap(Function.identity(), countDistinctVowels));

        return wordVowelsCountMap.entrySet().stream().parallel().unordered()
                .filter(e -> e.getValue() >= n)
                .map(Map.Entry::getKey)
                .collect(toList());
    }
}
