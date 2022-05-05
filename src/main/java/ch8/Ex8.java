package ch8;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex8 {
    public static void main(String[] args) {
        System.out.println(
                IntStream
                        .range(0, 10)
                        .mapToObj(i -> randomValue())
                        .collect(Collectors.flatMapping(Optional::stream, Collectors.toList()))
        );
    }

    public static Optional<Integer> randomValue() {
        var random = new Random();
        var rand1 = random.nextInt();
        var rand2 = random.nextInt();

        return Optional.ofNullable(rand1 > rand2 ? rand1 : null);
    }
}
