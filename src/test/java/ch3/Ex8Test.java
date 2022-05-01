package ch3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex8Test {
    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(List.of("a", "aa", "aaa"), true),
                Arguments.of(List.of("aaa", "aaaa", "a"), false),
                Arguments.of(List.of("a"), true),
                Arguments.of(List.of(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void returnExpectedResults(List<String> list, boolean expectedResult) {
        boolean result = Ex8.isSorted(list, Comparator.comparingInt(String::length));

        assertEquals(expectedResult, result);
    }
}