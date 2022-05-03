package ch7;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;

public class Ex1 {
    public static List<Integer> calcPrimes(int n) {
        var numbersSet = new HashSet<Integer>();

        for (int i = 2; i <= n; i++) {
            numbersSet.add(i);
        }

        for (int s = 2; s <= Math.sqrt(n); s++) {
            if (numbersSet.contains(s)) {
                for (int multiple = s * s; multiple <= n; multiple += s) {
                    numbersSet.remove(multiple);
                }
            }
        }

        return new ArrayList<>(numbersSet);
    }

    public static List<Integer> calcPrimes2(int n) {
        var numbersSet = new BitSet(n);

        for (int i = 2; i <= n; i++) {
            numbersSet.set(i);
        }

        for (int s = 2; s <= Math.sqrt(n); s++) {
            if (numbersSet.get(s)) {
                for (int multiple = s * s; multiple <= n; multiple += s) {
                    numbersSet.clear(multiple);
                }
            }
        }

        var result = new ArrayList<Integer>(numbersSet.cardinality());
        var i = numbersSet.nextSetBit(0);

        while (i != -1) {
            result.add(i);
            i = numbersSet.nextSetBit(i + 1);
        }

        return result;
    }
}
