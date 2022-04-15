package ch1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;

    @BeforeAll
    static void saveOriginalInAndOut() {
        originalOut = System.out;
        originalIn = System.in;
    }

    @AfterAll
    static void restoreOriginalInAndOut() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    ByteArrayOutputStream mockInAndOut(String inputString, String outputString) {
        ByteArrayOutputStream mockedOut;

        var in = new ByteArrayInputStream(inputString.getBytes());
        mockedOut = new ByteArrayOutputStream(outputString.length() * 2);
        System.setIn(in);
        System.setOut(new PrintStream(mockedOut));

        return mockedOut;
    }


    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("10", "binary: 1010 \noctal: 12 \nhexadecimal: a \nhexadecimal floating point: 0x1.999999999999ap-4 \n"),
                Arguments.of("0", "binary: 0 \noctal: 0 \nhexadecimal: 0 \nhexadecimal floating point: Infinity \n"),
                Arguments.of("h", "unexpected value")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void return_expected_result(String testcaseInput, String expectedResult) {
        ByteArrayOutputStream mockedOut = mockInAndOut(testcaseInput, expectedResult);

        Ex1.main(null);
        assertEquals(expectedResult, mockedOut.toString());
    }
}