package ch1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex14Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {16, 3, 2, 13},
                        {5, 10, 11, 8},
                        {9, 6, 7, 12},
                        {4, 15, 14, 1},
                }, true),
                Arguments.of(new int[][]{
                        {17, 3, 2, 13},
                        {5, 10, 11, 8},
                        {9, 6, 7, 12},
                        {4, 15, 14, 1},
                }, false),
                Arguments.of(new int[][]{
                        {16, 3, 2, 13},
                        {5, 10, 11, 18},
                        {9, 6, 7, 12},
                        {5, 15, 14, 1},
                }, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void returnExpectedResults(int[][] input, boolean expectedResult) {
        boolean result = Ex14.isMagicSquare(input);

        assertEquals(expectedResult, result);
    }
}