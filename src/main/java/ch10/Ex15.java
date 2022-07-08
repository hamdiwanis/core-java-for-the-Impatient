package ch10;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Ex15 {
    public static void countWordsInFile(Path path, Map<String, Integer> wordFrequencyMap) {
        try {
            try (var in = new Scanner(path)) {
                in.useDelimiter("[^\\w]+");

                in.tokens().forEach(word -> {
                    wordFrequencyMap.merge(word, 1, Integer::sum);
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        var wordFrequencyMap = new ConcurrentHashMap<String, Integer>();

        try (var filesList = Files.walk(Path.of("./temp"))) {
            filesList
                    .filter(path -> path.toFile().isFile())
                    .forEach(path -> executorService.execute(() -> countWordsInFile(path, wordFrequencyMap)));

            executorService.shutdown();

            while (!executorService.isTerminated()) {
                // wait for all tasks to finish
            }

            // calculate top 10 words
            var top10Words = wordFrequencyMap
                    .entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            System.out.println(top10Words);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
