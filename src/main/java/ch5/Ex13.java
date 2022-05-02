package ch5;

import java.util.Arrays;

public class Ex13 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        min(new int[]{1, 2, 3, 4, 5, 6, 7});
        long endTime = System.nanoTime();

        System.out.println("----------------------------------------------------");
        System.out.println("Execution time in nano second: " + (endTime - startTime));
    }

    public static int min(int[] values) {
        int minValue = values[0];

        for (var i : values) {
            if (i < minValue) {
                minValue = i;
            }
        }

        int finalMinValue = minValue;
        assert Arrays.stream(values).allMatch(value -> value >= finalMinValue);
        return minValue;
    }
}
