package ch7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntFunction;

public class Ex15 {
    public static List<Integer> listOf(IntFunction<Integer> generateFn) {
        return new ArrayList<Integer>() {
            @Override
            public Integer get(int index) {
                return generateFn.apply(index);
            }

            @Override
            public Integer set(int index, Integer element) {
                throw new UnsupportedOperationException();
            }

            @Override
            public int size() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return true;
                    }

                    @Override
                    public Integer next() {
                        return generateFn.apply(index++);
                    }
                };
            }
        };
    }
}
