package ch7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Ex12 {
    public static void main(String[] args) {
        var sentence = "This is a valid sentence.";
        var words = new ArrayList<>(List.of(sentence.substring(0, sentence.length() - 1).toLowerCase().split(" ")));
        Collections.shuffle(words);

        var newSentence = new StringBuilder();

        var firstWord = words.get(0);
        newSentence.append(firstWord.substring(0, 1).toUpperCase());
        newSentence.append(firstWord.substring(1));
        newSentence.append(" ");

        var stringJoiner = new StringJoiner(" ");
        for (int i = 1; i < words.size(); i++) {
            stringJoiner.add(words.get(i));
        }
        newSentence.append(stringJoiner);

        newSentence.append(".");

        System.out.println(newSentence);
    }
}
