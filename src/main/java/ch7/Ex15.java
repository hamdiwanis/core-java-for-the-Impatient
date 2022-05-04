package ch7;

import ch7.Ex13.Cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntFunction;

public class Ex15 {
    public static List<Integer> listOf(IntFunction<Integer> generateFn) {
        return new ArrayList<Integer>() {
            final Cache<Integer, Integer> cache = new Cache<>(10, 100);

            public Integer getFromCache(int index) {
                var value = cache.get(index);

                if (value == null) {
                    value = generateFn.apply(index);
                    cache.put(index, value);
                }

                return value;
            }

            @Override
            public Integer get(int index) {
                return getFromCache(index);
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
                        return getFromCache(index++);
                    }
                };
            }
        };
    }
}
