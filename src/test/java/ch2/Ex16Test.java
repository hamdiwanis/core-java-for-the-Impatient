package ch2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex16Test {
    @Test
    void workAsExpected() {
        var queue = new Ex16.Queue();

        queue.add("1");
        queue.add("2");
        queue.add("3");

        var item1 = queue.remove();
        queue.add("4");

        assertEquals("1", item1);
        assertEquals("2 -> 3 -> 4", queue.toString());
    }
}