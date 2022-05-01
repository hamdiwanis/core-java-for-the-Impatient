package ch2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex4Test {
    @Test
    void returnExpectedResults() {
        var int1 = new Ex4.IntHolder(1);
        var int2 = new Ex4.IntHolder(2);

        Ex4.swap(int1, int2);

        assertEquals(2, int1.getValue());
        assertEquals(1, int2.getValue());
    }
}