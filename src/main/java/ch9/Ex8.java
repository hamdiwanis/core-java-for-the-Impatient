package ch9;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class Ex8 {
    public static void zipDirectory(String target, String outputName) throws IOException {
        var targetPath = Paths.get(target);
        var outputPath = Paths.get(targetPath.getParent().toString(), outputName + ".zip");
        var outputUri = URI.create("jar:" + outputPath.toUri());

        try (
                var zipFS = FileSystems.newFileSystem(outputUri, Collections.singletonMap("create", "true"));
                var files = Files.walk(targetPath);
        ) {
            files.skip(1).forEach(file -> {
                try {
                    Files.copy(file, zipFS.getPath("\\" + targetPath.relativize(file)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
