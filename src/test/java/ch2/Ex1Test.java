package ch2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex1Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        DayOfWeek.FRIDAY,
                        LocalDate.of(2022, 4, 22),
                        "" +
                                " Fri Sat Sun Mon Tue Wed Thu\n" +
                                "   1   2   3   4   5   6   7\n" +
                                "   8   9  10  11  12  13  14\n" +
                                "  15  16  17  18  19  20  21\n" +
                                "  22  23  24  25  26  27  28\n" +
                                "  29  30" +
                                "\n\n"
                ),
                Arguments.of(
                        DayOfWeek.SATURDAY,
                        LocalDate.of(2022, 4, 22),
                        "" +
                                " Sat Sun Mon Tue Wed Thu Fri\n" +
                                "                           1\n" +
                                "   2   3   4   5   6   7   8\n" +
                                "   9  10  11  12  13  14  15\n" +
                                "  16  17  18  19  20  21  22\n" +
                                "  23  24  25  26  27  28  29\n" +
                                "  30" +
                                "\n\n"
                ),
                Arguments.of(
                        DayOfWeek.SUNDAY,
                        LocalDate.of(2022, 4, 22),
                        "" +
                                " Sun Mon Tue Wed Thu Fri Sat\n" +
                                "                       1   2\n" +
                                "   3   4   5   6   7   8   9\n" +
                                "  10  11  12  13  14  15  16\n" +
                                "  17  18  19  20  21  22  23\n" +
                                "  24  25  26  27  28  29  30" +
                                "\n\n"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void returnExpectedResults(DayOfWeek startDay, LocalDate day, String expectedResult) {
        String result = Ex1.calenderPage(startDay, day);

        assertEquals(expectedResult, result);
    }
}