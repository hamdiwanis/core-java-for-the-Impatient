package ch7;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        {
            try {
                var list = new ArrayList<>(List.of(1, 2, 3));
                for (var item : list) {
                    list.remove(0);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        {
            var list = new ArrayList<>(List.of(1, 2, 3));
            var listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next() == 2) {
                    listIterator.remove();
                }
            }
        }

        {
            var list = new ArrayList<>(List.of(1, 2, 3));
            list.removeIf(integer -> integer == 2);
        }
    }
}
