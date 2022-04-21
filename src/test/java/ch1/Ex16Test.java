package ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex16Test {
    @Test
    void work_with_one_input() {
        var result = Ex16.average(1.0);

        assertEquals(1.0, result);
    }

    @Test
    void work_with_multiple_inputs() {
        var result = Ex16.average(1.0, 2.0, 3.0);

        assertEquals(2.0, result);
    }
}