package ch1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex2Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(380, 20),
                Arguments.of(-2, 358),
                Arguments.of(-390, 330),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void returnExpectedResults(int testCase, int expectedResult) {
        int result = Ex2.normalizeDegree(testCase);

        assertEquals(expectedResult, result);
    }
}