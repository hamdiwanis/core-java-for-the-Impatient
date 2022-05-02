package ch6;

import java.util.Arrays;

public class Ex2 {
    public static class Stack<E> {
        private Object[] list;
        private int index = 0;

        public Stack() {
            this(10);
        }

        public Stack(int capacity) {
            list = new Object[capacity];
        }

        @SuppressWarnings("unchecked")
        public E pop() {
            if (isEmpty()) {
                return null;
            }

            var value = list[--index];

            if (index < list.length / 4) {
                list = Arrays.copyOfRange(list, 0, list.length / 2);
            }

            return (E) value;
        }

        public void push(E value) {
            if (index == list.length - 1) {
                list = Arrays.copyOf(list, list.length * 2);
            }

            list[index++] = value;
        }

        public boolean isEmpty() {
            return index == 0;
        }
    }
}
