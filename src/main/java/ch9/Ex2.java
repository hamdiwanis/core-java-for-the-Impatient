package ch9;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static ch7.Ex8.findWordsInfile;

public class Ex2 {
    public static void tokenize(String filePath) throws IOException {
        var outFilePath = filePath.substring(0, filePath.lastIndexOf(".")) + ".toc";

        try (var outWriter = new PrintWriter(Files.newBufferedWriter(Path.of(outFilePath)))) {
            var wordsLine = findWordsInfile(filePath);
            wordsLine.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(String::compareToIgnoreCase))
                    .forEachOrdered(e -> outWriter.println(e.getKey() + "  " + e.getValue()));
        }
    }
}
