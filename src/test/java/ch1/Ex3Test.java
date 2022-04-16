package ch1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex3Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(1, 3, 2, 3),
                Arguments.of(-1, -3, -2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void return_expected_results(int number1, int number2, int number3, int expectedResult) {
        int result = Ex3.findLargest(number1, number2, number3);

        assertEquals(expectedResult, result);
    }
}