package ch1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex8Test {
    @Test
    void returnExpectedResults() {
        List<String> result = Ex8.printNonEmptySubStrings("H7 E");

        assertEquals("[H7 E, H7, H, 7 E, 7, E]", result.toString());
    }
}