package ch2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex5Test {
    @Test
    void return_expected_results() {
        var point = new Ex5.Point(3, 4).translate(1, 3).scale(0.5);

        assertEquals(2, point.getX());
        assertEquals(3.5, point.getY());
    }
}