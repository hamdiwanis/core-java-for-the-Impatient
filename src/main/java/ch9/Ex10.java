package ch9;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Ex10 {
    public static void main(String[] args) {
        var testString = "10 +20 -11 44 + 13 ABC 7 12.5";

        {
            var list = new ArrayList<Double>();
            var numberRegex = Pattern.compile("[+-]?\\d+(\\.\\d+)?");
            var matcher = numberRegex.matcher(testString);

            while (matcher.find()) {
                list.add(Double.parseDouble(matcher.group()));
            }

            System.out.println(list);
        }

        {
            var list = new ArrayList<Double>();
            var notNumberRegex = "\\s?[^\\d]*\\s";
            for (var part : testString.split(notNumberRegex)) {
                list.add(Double.parseDouble(part));
            }

            System.out.println(list);
        }
    }
}
