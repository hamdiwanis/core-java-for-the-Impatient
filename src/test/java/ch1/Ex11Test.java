package ch1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex11Test {
    @Test
    void returnExpectedResults() {
        ArrayList<String> result = Ex11.findNonAscii("Hµ7ç");

        assertEquals("[µ_181, ç_231]", result.toString());
    }
}