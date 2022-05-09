package ch10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex1 {
    public static List<File> findFilesContains(String rootPath, String term) throws IOException {
        try (var files = Files.list(Path.of(rootPath))) {
            return files.parallel()
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .filter(file -> isContentContains(file, term))
                    .collect(Collectors.toList());
        }
    }

    public static Optional<File> findFileContains(String rootPath, String term) throws IOException {
        try (var files = Files.list(Path.of(rootPath))) {
            return files.parallel()
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .filter(file -> isContentContains(file, term))
                    .findFirst();
        }
    }

    public static boolean isContentContains(File file, String term) {
        try (var in = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = in.readLine()) != null) {
                var words = line.split("[^\\w]+");

                for (var word : words) {
                    if (word.equals(term)) return true;
                }
            }

            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
