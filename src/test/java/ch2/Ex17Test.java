package ch2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex17Test {
    @Test
    void work_as_expected() {
        var queue = new Ex16.Queue();

        queue.add("1");
        queue.add("2");
        queue.add("3");

        var valuesList = new ArrayList<String>();

        for (var value : queue) {
            valuesList.add(value);
        }

        assertEquals("[1, 2, 3]", valuesList.toString());
    }
}