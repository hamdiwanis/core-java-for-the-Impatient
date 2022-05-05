package ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ex14 {
    public static <T> List<T> reduceListStream(Stream<List<T>> stream) {
        return stream.reduce(new ArrayList<T>(), (p, n) -> {
            p.addAll(n);
            return p;
        });
    }
}
