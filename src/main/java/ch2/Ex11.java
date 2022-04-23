package ch2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static java.time.LocalDate.now;
import static java.time.LocalDate.of;

public class Ex11 {
    public static String calenderPage(DayOfWeek startDay, LocalDate day) {
        var calenderPage = new StringBuilder();

        var currentMonth = day.getMonth().getValue();
        var date = of(day.getYear(), currentMonth, 1);

        // add months names
        for (int i = 0; i < 7; i++) {
            calenderPage.append(" ");
            calenderPage.append(startDay.plus(i).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        }
        calenderPage.append("\n");

        // add days
        while (date.getMonthValue() == currentMonth) {
            var dayOfWeek = date.getDayOfWeek().getValue();
            var dayOfMonth = date.getDayOfMonth();

            if (dayOfMonth == 1) {
                // add offset space if first day of the month
                var daysOffset = dayOfWeek + (DayOfWeek.MONDAY.getValue() - (startDay.getValue() % 7));

                if (daysOffset < 1) {
                    daysOffset = 7 - daysOffset;
                }

                calenderPage.append(" ".repeat(4 * (daysOffset - 1)));
            } else if (dayOfWeek == startDay.getValue()) {
                // start new line if last day
                calenderPage.append("\n");
            }

            // format day as 4 digits to align with month name
            calenderPage.append(String.format("%4d", dayOfMonth));

            date = date.plusDays(1);
        }

        calenderPage.append("\n\n");

        return calenderPage.toString();
    }

    public static String calenderPage() {
        return calenderPage(DayOfWeek.SATURDAY, now());
    }

    public static String calenderPage(DayOfWeek startDay) {
        return calenderPage(startDay, now());
    }

    public static String calenderPage(LocalDate day) {
        return calenderPage(DayOfWeek.SATURDAY, day);
    }
}
