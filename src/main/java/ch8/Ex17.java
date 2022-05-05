package ch8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex17 {
    public static List<String> findNLongestStrings(String filePath, int n) throws FileNotFoundException {
        var in = new Scanner(new File(filePath));
        in.useDelimiter("\\PL+");

        return in.tokens()
                .parallel()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}
