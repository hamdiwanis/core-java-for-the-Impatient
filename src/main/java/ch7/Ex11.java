package ch7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        var words = new ArrayList<>(List.of("This is a valid sentence".split(" ")));
        Collections.shuffle(words.subList(1, words.size() - 1));

        System.out.println(words);
    }
}
