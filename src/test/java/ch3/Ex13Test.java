package ch3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex13Test {
    static File generateMockedFile(String name, boolean isDirectory) {
        return new File(name) {
            @Override
            public boolean isDirectory() {
                return isDirectory;
            }

            @Override
            public String toString() {
                return getPath();
            }
        };
    }

    @Test
    void returnExpectedResult() {
        File[] files = {
                generateMockedFile("a", true),
                generateMockedFile("d", false),
                generateMockedFile("b", true),
                generateMockedFile("c", true),
                generateMockedFile("x", false),
        };

        Ex13.sortFiles(files);

        assertEquals("[a, b, c, d, x]", Arrays.toString(files));
    }
}