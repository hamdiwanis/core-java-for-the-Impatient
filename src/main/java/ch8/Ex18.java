package ch8;

import java.util.stream.Stream;

public class Ex18 {
    @SuppressWarnings("unchecked")
    public static <T> Stream<T> eliminateAdjacentDuplicates(Stream<T> stream) {
        var lastValue = (T[]) new Object[1];

        return stream.filter(value -> {
            var remove = value.equals(lastValue[0]);
            lastValue[0] = value;
            return !remove;
        });
    }
}
