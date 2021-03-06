package ch6;

public class Ex7 {
    public static class Pair<E> {
        private final E first, second;

        public Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }

        public E getFirst() {
            return first;
        }

        public E getSecond() {
            return second;
        }
    }
}
