package ch8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex7 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(mostFrequent10WordsInFile("text.txt"));
    }

    public static List<String> listFirst100WordsFile(String filePath) throws FileNotFoundException {
        var in = new Scanner(new File(filePath));
        in.useDelimiter("\\PL+");

        return in.tokens().filter(Ex7::isWord).limit(100).collect(Collectors.toList());
    }

    public static List<String> mostFrequent10WordsInFile(String filePath) throws FileNotFoundException {
        var in = new Scanner(new File(filePath));
        in.useDelimiter("\\PL+");

        return in.tokens().filter(Ex7::isWord)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> mostFrequent10WordsInFile2(String filePath) throws FileNotFoundException {
        var in = new Scanner(new File(filePath));
        in.useDelimiter("\\PL+");

        return in.tokens().filter(Ex7::isWord)
                .map(String::toLowerCase)
                .collect(Collectors.toMap(Function.identity(), x -> 1, (p, n) -> p + 1))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static boolean isWord(String s) {
        return s.codePoints().allMatch(Character::isAlphabetic);
    }
}
