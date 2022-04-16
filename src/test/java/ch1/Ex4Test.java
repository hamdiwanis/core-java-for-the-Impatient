package ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex4Test {
    @Test
    void return_expected_results() {
        double[] result = Ex4.smallestAndLargestPositiveDoubleValues();

        assertEquals(Double.MIN_VALUE, result[0]);
        assertEquals(Double.MAX_VALUE, result[1]);
    }
}