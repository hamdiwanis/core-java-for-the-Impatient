package ch6;

public class Ex8 {
    public static class Pair<E extends Comparable<? super E>> {
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

        public E max() {
            return first.compareTo(second) < 0 ? second : first;
        }

        public E min() {
            return first.compareTo(second) > 0 ? second : first;
        }
    }
}
