package ch10;

import java.util.concurrent.ConcurrentHashMap;

public class Ex8 {
    public static void main(String[] args) {
        var wordLength = new ConcurrentHashMap<String, Long>();

        // populate values

        var maxLengthWordEntry = wordLength.reduceEntries(
                1,
                (prev, curr) -> curr.getValue() > prev.getValue() ? curr : prev
        );
        System.out.println(maxLengthWordEntry);
    }
}
