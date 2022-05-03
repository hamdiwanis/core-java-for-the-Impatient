package ch7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex8 {
    public static Map<String, Set<Integer>> findWordsInfile(String filePath) throws FileNotFoundException {
        var wordsMap = new HashMap<String, Set<Integer>>();

        try (var in = new Scanner(new File(filePath))) {
            var lineIndex = 1;
            while (in.hasNextLine()) {
                var wordsRegex = Pattern.compile("[\\w\\d]*");
                var line = in.nextLine();
                var matcher = wordsRegex.matcher(line);
                var words = matcher.results()
                        .map(result -> line.substring(result.start(), result.end()))
                        .collect(Collectors.toList());

                for (var word : words) {
                    if (word.length() == 0) {
                        continue;
                    }

                    var lines = wordsMap.getOrDefault(word, new HashSet<>());
                    lines.add(lineIndex);
                    wordsMap.put(word, lines);
                }

                lineIndex++;
            }
        }

        return wordsMap;
    }
}
