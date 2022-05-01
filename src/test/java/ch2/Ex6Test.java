package ch2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex6Test {
    @Test
    void returnExpectedResults() {
        var point = new Ex6.Point(3, 4);

        point.translate(1, 3);
        point.scale(0.5);

        assertEquals(2, point.getX());
        assertEquals(3.5, point.getY());
    }
}