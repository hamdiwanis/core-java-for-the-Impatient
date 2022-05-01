package ch3;

import java.math.BigInteger;

public class Ex6 {
    public interface Sequence<T> {
        default boolean hasNext() {
            return true;
        }

        T next();
    }

    public static class SquareSequence implements Sequence<BigInteger> {
        BigInteger value = BigInteger.ONE;

        @Override
        public BigInteger next() {
            var res = value.multiply(value);
            value = value.add(BigInteger.ONE);

            return res;
        }
    }
}
