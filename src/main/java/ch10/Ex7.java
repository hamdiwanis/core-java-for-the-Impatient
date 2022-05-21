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

public class Ex7 {
    public static void main(String[] args) throws InterruptedException, IOException {
        try (var filesList = Files.list(Path.of("./temp"))) {
            var wordToFileMap = new ConcurrentHashMap<String, Set<File>>();

            filesList.parallel().forEach(path -> {
                try (var in = new Scanner(path)) {
                    in.useDelimiter("[^\\w]+");
                    in.tokens().forEach(word -> {
                        // no need to recreate the file set
                        wordToFileMap.computeIfAbsent(
                                word,
                                (_ignore) -> new HashSet<>(List.of(path.toFile()))
                        ).add(path.toFile());
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            System.out.println(wordToFileMap);
        }
    }
}
