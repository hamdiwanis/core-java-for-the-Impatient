package ch9;

import java.util.List;

public class Ex12 {
    public static void main(String[] args) {
        System.out.println(
                highlightWords("I use JAVA more than JS", List.of("java", "js"))
        );
    }

    public static String highlightWords(String s, List<String> wordsList) {
        return s.replaceAll("(?i)(" + String.join("|", wordsList) + ")", "★$1★");
    }
}
