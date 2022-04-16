package ch1;

import java.util.ArrayList;

public class Ex8 {
    public static ArrayList<String> printNonEmptySubStrings(String input) {
        var subStrings = new ArrayList<String>();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) continue;

            for (int j = input.length() - 1; j >= i; j--) {
                if (Character.isWhitespace(input.charAt(j))) continue;

                subStrings.add(input.substring(i, j + 1));
            }
        }

        return subStrings;
    }
}
