package ch10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Ex13 {
    static Supplier<Map<String, Integer>> processFile(Path path) {
        return () -> {
            try {
                try (var in = new Scanner(path)) {
                    in.useDelimiter("[^\\w]+");

                    var wordFrequencyMap = new HashMap<String, Integer>();

                    in.tokens().forEach(word -> {
                        wordFrequencyMap.merge(word, 1, Integer::sum);
                    });

                    return wordFrequencyMap;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try (var filesList = Files.walk(Path.of("./temp"))) {
            var top10Words = filesList
                    .filter(path -> path.toFile().isFile())
                    .map(path -> CompletableFuture.supplyAsync(processFile(path), executorService))
                    .map(CompletableFuture::join)
                    .flatMap(m -> m.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum))
                    .entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            System.out.println(top10Words);

            executorService.shutdown();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
