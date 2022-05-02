package ch6;

import java.util.ArrayList;

public class Ex1 {
    public static class Stack<E> {
        private ArrayList<E> list = new ArrayList<>();

        public E pop() {
            if (isEmpty()) {
                return null;
            }

            return list.remove(list.size() - 1);
        }

        public void push(E value) {
            list.add(value);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}
