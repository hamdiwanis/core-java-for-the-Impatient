package ch6;

import java.util.ArrayList;

public class Ex4 {
    public static class Table<K, V> {
        private final ArrayList<Entry> entries = new ArrayList<>();

        public V get(K key) {
            for (var entry : entries) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }

            return null;
        }

        public void put(K key, V value) {
            for (var entry : entries) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
            }

            entries.add(new Entry(key, value));
        }

        public void remove(K key) {
            entries.removeIf(entry -> entry.getKey().equals(key));
        }

        public class Entry {
            private final K key;
            private V value;

            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public void setValue(V value) {
                this.value = value;
            }
        }
    }
}
