package ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex5Test {
    @Test
    void fixedIntValueWhenCastDoubleIsLargerThanIntCapacity() {
        double overflow = 7.0;
        int result = Ex5.doubleToInt(Integer.MAX_VALUE + overflow);

        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    void overflowWhenValueIsLargerThanByteCapacity() {
        int overflow = 2;
        int result = Ex5.intToByte(Byte.MAX_VALUE + overflow);

        assertEquals(Byte.MIN_VALUE + (overflow - 1), result);
    }
}