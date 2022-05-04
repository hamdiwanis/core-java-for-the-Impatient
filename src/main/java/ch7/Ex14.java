package ch7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex14 {
    public static List<Integer> listOf(int n) {
        return new ArrayList<Integer>() {
            @Override
            public Integer get(int index) {
                if (index > n || index < 0) {
                    throw new IndexOutOfBoundsException();
                } else {
                    return index;
                }
            }

            @Override
            public Integer set(int index, Integer element) {
                throw new UnsupportedOperationException();
            }

            @Override
            public int size() {
                return n + 1;
            }

            @Override
            public Object[] toArray() {
                var arr = new Object[n];

                for (int i = 0; i <= n; i++) {
                    arr[i] = i;
                }

                return arr;
            }

            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index <= n;
                    }

                    @Override
                    public Integer next() {
                        return index++;
                    }
                };
            }
        };
    }
}
