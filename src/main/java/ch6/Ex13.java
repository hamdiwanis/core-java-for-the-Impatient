package ch6;

import java.util.Comparator;
import java.util.List;

import static ch6.Ex12.minmax;

public class Ex13 {
    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        swapHelper(result, 0, 1);
    }

    private static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
