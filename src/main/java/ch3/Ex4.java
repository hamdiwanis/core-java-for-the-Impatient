package ch3;

public class Ex4 {
    public static abstract class IntSequence {
        static IntSequence of(int... list) {
            return new IntSequence() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < list.length;
                }

                @Override
                public int next() {
                    return list[index++];
                }
            };
        }

        abstract boolean hasNext();

        abstract int next();
    }
}
