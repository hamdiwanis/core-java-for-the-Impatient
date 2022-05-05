package ch8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex4 {
    public static void main(String[] args) {
        var stream = linearCongruentialGenerator(System.currentTimeMillis(), 25214903917L, 11, 248);
        var values = stream.limit(7).collect(Collectors.toList());

        System.out.println(values);
    }

    public static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
        return Stream
                .iterate(seed, x -> ((x * a) + c) % m)
                .skip(1);
    }
}
