package ch3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex15Test {
    @Test
    void returnExpectedResult() {
        Ex15.Employee[] employees = {
                new Ex15.Employee("a", 30),
                new Ex15.Employee("b", 40),
                new Ex15.Employee("d", 20),
                new Ex15.Employee("c", 20),
        };

        Ex15.sortEmployees(employees, false);

        assertEquals("[c, d, a, b]", Arrays.toString(employees));
    }

    @Test
    void returnExpectedResultIfReversed() {
        Ex15.Employee[] employees = {
                new Ex15.Employee("a", 30),
                new Ex15.Employee("b", 40),
                new Ex15.Employee("d", 20),
                new Ex15.Employee("c", 20),
        };

        Ex15.sortEmployees(employees, true);

        assertEquals("[b, a, d, c]", Arrays.toString(employees));
    }
}