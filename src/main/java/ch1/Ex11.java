package ch1;

import java.util.ArrayList;

public class Ex11 {
    public static ArrayList<String> findNonAscii(String input) {
        var result = new ArrayList<String>();

        for (char currentChar : input.toCharArray()) {
            if (currentChar > 127) {
                result.add(currentChar + "_" + (int) currentChar);
            }
        }

        return result;
    }
}
