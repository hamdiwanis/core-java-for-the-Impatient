package ch10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Ex11 {
    public static void main(String[] args) {
        final var files = new ArrayBlockingQueue<Path>(10);
        final var keywords = List.of("keyword1", "keyword2");

        final var endSignal = Path.of("");

        // consumers
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        if (files.peek() == endSignal) {
                            return;
                        }

                        Path path = files.take();
                        try (var in = new Scanner(path)) {
                            in.useDelimiter("[^\\w]+");

                            in.tokens().forEach(word -> {
                                if (keywords.contains(word)) {
                                    System.out.println("Found keyword: " + word + ", in path: " + path);
                                }
                            });
                        }
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

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
