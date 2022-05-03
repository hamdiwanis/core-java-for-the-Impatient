package ch7;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ex13 {
    public static class Cache<K, V> extends LinkedHashMap<K, V> {
        private int limit;

        public Cache(int capacity, int limit) {
            super(capacity);
            this.limit = limit;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > limit;
        }
    }
}
