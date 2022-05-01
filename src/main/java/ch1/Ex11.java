package ch1;

import java.util.ArrayList;
import java.util.List;

public class Ex11 {
    public static List<String> findNonAscii(String input) {
        var result = new ArrayList<String>();

        for (char currentChar : input.toCharArray()) {
            if (currentChar > 127) {
                result.add(currentChar + "_" + (int) currentChar);
            }
        }

        return result;
    }
}
