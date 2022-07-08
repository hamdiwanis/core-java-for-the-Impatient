package ch10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class Ex12 {
    public static void main(String[] args) {
        final var files = new ArrayBlockingQueue<Path>(10);
        final var processedFilesRes = new ArrayBlockingQueue<HashMap<String, Integer>>(10);

        final var endSignal = Path.of("");

        var consumerThreads = new ArrayList<Thread>();

        // consumers
        for (int i = 0; i < 2; i++) {
            var consumerThread = new Thread(() -> {
                try {
                    while (true) {
                        if (files.peek() == endSignal) {
                            return;
                        }

                        Path path = files.take();
                        try (var in = new Scanner(path)) {
                            in.useDelimiter("[^\\w]+");

                            var wordFrequencyMap = new HashMap<String, Integer>();

                            in.tokens().forEach(word -> {
                                wordFrequencyMap.merge(word, 1, Integer::sum);
                            });

                            processedFilesRes.add(wordFrequencyMap);
                        }
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            consumerThread.start();

            consumerThreads.add(consumerThread);
        }

        // merger
        new Thread(() -> {
            consumerThreads.forEach(consumerThread -> {
                try {
                    consumerThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            var mergedWordFrequencyMap = new HashMap<String, Integer>();

            processedFilesRes.forEach(wordFrequencyMap -> {
                wordFrequencyMap.keySet().forEach(word -> {
                    mergedWordFrequencyMap.merge(word, wordFrequencyMap.get(word), Integer::sum);
                });
            });

            var top10Words = mergedWordFrequencyMap
                    .entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            System.out.println(top10Words);
        }).start();

        // producer
        new Thread(() -> {
            try (var filesList = Files.walk(Path.of("./temp"))) {
                filesList.forEach(path -> {
                    if (path.toFile().isFile()) {
                        files.add(path);
                    }
                });

                files.add(endSignal);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
