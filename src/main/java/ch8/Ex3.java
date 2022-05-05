package ch8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex3 {
    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        Stream<int[]> streamOfNumbersArrays = Stream.of(values);
        IntStream streamOfNumbers = Arrays.stream(values);
    }
}
