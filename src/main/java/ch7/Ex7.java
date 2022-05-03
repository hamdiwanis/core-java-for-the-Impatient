package ch7;

import java.util.Map;
import java.util.TreeMap;

public class Ex7 {
    public static Map<String, Integer> countWordsInfile(String filePath) {
        String[] words = readWordsInfile(filePath);

        var wordCount = new TreeMap<String, Integer>();

        for (var item : words) {
            wordCount.merge(item, 1, Integer::sum);
        }

        return wordCount;
    }

    public static String[] readWordsInfile(String filePath) {
        // todo: read words from file
        return new String[]{"ABC", "ABC", "XYZ", "EFG", "XYZ", "XYZ", "HMD"};
    }
}
