package ch7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex8 {
    public static Map<String, Set<Integer>> findWordsInfile(String filePath) throws FileNotFoundException, IOException {
        var wordsMap = new HashMap<String, Set<Integer>>();

        var wordsRegex = Pattern.compile("[\\w\\d]*");
        try (var reader = Files.newBufferedReader(Path.of(filePath))) {
            var line = reader.readLine();
            var lineIndex = 1;
            while (line != null) {
                var matcher = wordsRegex.matcher(line);
                var words = matcher.results().map(MatchResult::group).collect(Collectors.toList());

                for (var word : words) {
                    if (word.length() == 0) {
                        continue;
                    }

                    var lines = wordsMap.getOrDefault(word, new HashSet<>());
                    lines.add(lineIndex);
                    wordsMap.put(word, lines);
                }

                line = reader.readLine();
                lineIndex++;
            }
        }

        return wordsMap;
    }
}
