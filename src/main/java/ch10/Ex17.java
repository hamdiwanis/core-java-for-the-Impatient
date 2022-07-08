package ch10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex17 {
    public static long count = 0;

    public static void main(String[] args) throws InterruptedException {
        try (var filesList = Files.walk(Path.of("./temp"))) {
            var fileSearchers = filesList
                    .filter(path -> path.toFile().isFile())
                    .map(path -> new Thread(() -> {
                        try {
                            try (var in = new Scanner(path)) {
                                in.useDelimiter("[^\\w]+");
                                in.tokens().forEach(word -> count++);
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })).collect(Collectors.toList());

            fileSearchers.forEach(Thread::start);
            for (var thread : fileSearchers) {
                thread.join();
            }

            System.out.println("count: " + count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
