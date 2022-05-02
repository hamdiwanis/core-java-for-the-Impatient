package ch6;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex12 {
    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        result.add(Collections.min(elements, comp));
        result.add(Collections.max(elements, comp));
    }
}
