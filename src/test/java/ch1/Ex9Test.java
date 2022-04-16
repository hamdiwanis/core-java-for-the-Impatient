package ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex9Test {
    @Test
    void return_expected_results() {
        String string1 = new String("H7");
        String string2 = new String("H7");

        assertEquals(false, string1 == string2);
        assertEquals(true, string1.equals(string2));
    }
}