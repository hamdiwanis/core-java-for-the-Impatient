package ch3;

import java.util.Random;

public class Ex16 {
    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }

    public interface IntSequence {
        boolean hasNext();

        int next();
    }

    public static class RandomSequence implements IntSequence {
        private static Random generator = new Random();
        private final int low;
        private final int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }
}
