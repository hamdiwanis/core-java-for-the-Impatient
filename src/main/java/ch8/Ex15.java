package ch8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex15 {
    public static double reduceAverage(Stream<Double> stream) {
        return stream.collect(Collectors.summarizingDouble(x -> x)).getAverage();
    }
}
