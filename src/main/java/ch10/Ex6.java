package ch10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Ex6 {
    public static void main(String[] args) throws InterruptedException, IOException {
        try (var filesList = Files.list(Path.of("./temp"))) {
            var wordToFileMap = new ConcurrentHashMap<String, Set<File>>();

            filesList.parallel().forEach(path -> {
                try (var in = new Scanner(path)) {
                    in.useDelimiter("[^\\w]+");
                    in.tokens().forEach(word -> {
                        wordToFileMap.merge(
                                word,
                                new HashSet<>(List.of(path.toFile())),
                                (prev, curr) -> {
                                    prev.addAll(curr);
                                    return prev;
                                }
                        );
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            System.out.println(wordToFileMap);
        }
    }
}
