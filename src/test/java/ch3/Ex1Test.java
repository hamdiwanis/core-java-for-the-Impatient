package ch3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex1Test {
    @Test
    void returnExpectedAverage() {
        Ex1.Employee[] employees = {
                new Ex1.Employee("Employee1", 1.5),
                new Ex1.Employee("Employee2", 2.0),
                new Ex1.Employee("Employee3", 2.5)
        };

        double result = Ex1.average(employees);

        assertEquals(2.0, result);
    }

    @Test
    void returnExpectedLargest() {
        Ex1.Employee[] employees = {
                new Ex1.Employee("Employee1", 1.5),
                new Ex1.Employee("Employee2", 2.0),
                new Ex1.Employee("Employee3", 2.5)
        };

        var largest = Ex1.largest(employees);
        String largestName = ((Ex1.Employee) largest).getName();

        assertEquals("Employee3", largestName);
    }
}