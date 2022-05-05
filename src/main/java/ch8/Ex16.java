package ch8;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex16 {
    public static List<BigInteger> findNPrimesWithMDigits(int n, int m) {
        BigInteger seed = BigInteger.valueOf((long) Math.pow(10, m));

        return Stream
                .iterate(seed, p -> p.add(BigInteger.ONE))
                .parallel()
                .unordered()
                .filter(i -> i.isProbablePrime(10))
                .limit(n)
                .collect(Collectors.toList());
    }
}
