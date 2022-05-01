package ch1;

import java.util.ArrayList;
import java.util.List;

public class Ex15 {
    static public List<? extends List<Integer>> generatePascal(int n) {
        var pascal = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            var innerList = new ArrayList<Integer>(List.of(1));

            for (int j = 1; j < i; j++) {
                var prevList = pascal.get(i - 1);
                innerList.add(prevList.get(j) + prevList.get(j - 1));
            }

            if (i != 0) {
                innerList.add(1);
            }

            pascal.add(innerList);
        }

        return pascal;
    }
}
