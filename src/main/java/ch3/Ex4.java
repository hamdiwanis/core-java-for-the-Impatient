package ch3;

public class Ex4 {
    interface IntSequence {
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

        static IntSequence constant(int value) {
            return () -> value;
        }

        default boolean hasNext() {
            return true;
        }

        int next();
    }
}
