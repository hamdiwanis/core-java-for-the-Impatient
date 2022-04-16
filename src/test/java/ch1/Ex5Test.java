package ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex5Test {
    @Test
    void fixed_int_value_when_cast_double_is_larger_than_int_capacity() {
        double overflow = 7.0;
        int result = Ex5.doubleToInt(Integer.MAX_VALUE + overflow);

        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    void overflow_when_value_is_larger_than_byte_capacity() {
        int overflow = 2;
        int result = Ex5.intToByte(Byte.MAX_VALUE + overflow);

        assertEquals(Byte.MIN_VALUE + (overflow - 1), result);
    }
}