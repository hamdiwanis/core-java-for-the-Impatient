package ch7;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        {
            var list = new ArrayList<>(List.of("abc", "xyz"));

            var listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(listIterator.next().toUpperCase());
            }

            System.out.println(list);
        }

        {
            var list = new ArrayList<>(List.of("abc", "xyz"));

            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }

            System.out.println(list);
        }

        {
            var list = new ArrayList<>(List.of("abc", "xyz"));
            list.replaceAll(String::toUpperCase);

            System.out.println(list);
        }

    }
}
