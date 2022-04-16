package ch1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Ex13 {
    public static Integer[] generateLotteryCombination() {
        var combination = new HashSet<Integer>();
        var randomGenerator = new Random(System.currentTimeMillis());

        while (combination.size() != 6) {
            int value = randomGenerator.nextInt(49) + 1;
            combination.add(value);
        }

        var combinationArray = combination.toArray(new Integer[0]);
        Arrays.sort(combinationArray);

        return combinationArray;
    }
}
