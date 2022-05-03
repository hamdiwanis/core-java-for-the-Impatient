package ch7;

import java.util.List;
import java.util.RandomAccess;

public class Ex5 {
    public static void swap(List<?> list, int i, int j) {
        assert j > i;

        if (list instanceof RandomAccess) {
            swapRandomAccessListHelper(list, i, j);
        } else {
            swapNonRandomAccessListHelper(list, i, j);
        }
    }

    private static <T> void swapRandomAccessListHelper(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static <T> void swapNonRandomAccessListHelper(List<T> list, int i, int j) {
        var listIterator = list.listIterator(i);
        T first = listIterator.next();

        int index = i + 1;

        while (index++ < j) {
            listIterator.next();
        }

        T second = listIterator.next();
        listIterator.set(first);

        while (index-- > i) {
            listIterator.previous();
        }

        listIterator.set(second);
    }
}
