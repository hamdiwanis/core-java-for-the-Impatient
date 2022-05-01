package ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex13Test {
    @Test
    void hasRightLength() {
        Integer[] result = Ex13.generateLotteryCombination();

        assertEquals(6, result.length);
    }

    @Test
    void arrayIsSorted() {
        Integer[] result = Ex13.generateLotteryCombination();

        for (int i = 0; i < result.length - 1; i++) {
            assertTrue(result[i] < result[i + 1]);
        }
    }

    @Test
    void arrayIsInRange() {
        Integer[] result = Ex13.generateLotteryCombination();

        for (int i = 0; i < result.length - 1; i++) {
            assertTrue(result[i] <= 49 && result[i] >= 0);
        }
    }
}