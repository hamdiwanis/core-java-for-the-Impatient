package ch8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex12 {
    public static <T> boolean isFinite(Stream<T> stream) {
        stream.collect(Collectors.toList());
        return true;
    }
}
