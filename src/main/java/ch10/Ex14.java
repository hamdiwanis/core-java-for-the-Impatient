package ch10;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Ex14 {
    static Callable<Map<String, Integer>> processFile(Path path) {
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
        CompletionService<Map<String, Integer>> completionService = new ExecutorCompletionService<>(executorService);

        try (var filesList = Files.walk(Path.of("./temp"))) {
            AtomicInteger fileCount = new AtomicInteger();

            filesList
                    .filter(path -> path.toFile().isFile())
                    .forEach(path -> {
                        fileCount.getAndIncrement();
                        completionService.submit(processFile(path));
                    });

            executorService.shutdown();

            // merge results as they are added
            var mergedWordFrequencyMap = new HashMap<String, Integer>();

            for (int i = 0; i < fileCount.get(); ++i) {
                var processedResult = completionService.take();
                var fileWordFrequencyMap = processedResult.get();

                fileWordFrequencyMap.keySet().forEach(word -> {
                    mergedWordFrequencyMap.merge(word, fileWordFrequencyMap.get(word), Integer::sum);
                });
            }

            // calculate top 10 words
            var top10Words = mergedWordFrequencyMap
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
