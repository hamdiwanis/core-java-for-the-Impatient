package ch10;

import java.util.concurrent.atomic.LongAccumulator;

public class Ex10 {
    public static void main(String[] args) {
        var maxAccumulator = new LongAccumulator(Long::max, 0);
        maxAccumulator.accumulate(1);
        maxAccumulator.accumulate(3);
        maxAccumulator.accumulate(2);
        System.out.println("max value: " + maxAccumulator.get());

        var minAccumulator = new LongAccumulator(Long::min, Long.MAX_VALUE);
        minAccumulator.accumulate(1);
        minAccumulator.accumulate(3);
        minAccumulator.accumulate(2);
        System.out.println("min value: " + minAccumulator.get());
    }
}
