package ch3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex8 {
    public static <T> boolean isSorted(List<? extends T> list, Comparator<? super T> comp) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (comp.compare(list.get(i), list.get(i + 1)) > 0) {
                return false;
            }
        }

        return true;
    }

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        while (!isSorted(strings, comp)) {
            Collections.shuffle(strings);
        }
    }
}
