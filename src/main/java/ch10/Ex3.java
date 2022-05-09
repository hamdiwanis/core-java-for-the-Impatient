package ch10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        var rootPath = "";
        var term = "";

        try (var files = Files.list(Path.of(rootPath))) {
            var executor = Executors.newFixedThreadPool(2);

            files
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .map(file -> searchInFile(file, term))
                    .forEach(task -> {
                        CompletableFuture
                                .supplyAsync(task, executor)
                                .thenAccept(isFound -> {
                                    if (isFound) executor.shutdown();
                                });
                    });
        }
    }

    public static Supplier<Boolean> searchInFile(File file, String term) {
        return () -> {
            var filePath = file.toPath();

            try (var in = Files.newBufferedReader(filePath)) {
                String line;
                while ((line = in.readLine()) != null) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Search task was interrupted file: " + filePath);
                        return false;
                    }

                    var words = line.split("[^\\w]+");

                    for (var word : words) {
                        if (word.equals(term)) {
                            System.out.println("Term '" + term + "' was found in file: " + filePath);
                            return true;
                        }
                    }
                }
            } catch (IOException ignored) {
            }

            return false;
        };
    }
}
