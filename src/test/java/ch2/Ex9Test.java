package ch2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex9Test {
    @Test
    void workAsExpected() {
        var perfectCar = new Ex9.Car(1);

        perfectCar.reFill(7);
        try {
            perfectCar.move(5);
            perfectCar.move(1);
        } catch (Exception ignored) {
        }

        assertEquals(6, perfectCar.getTraveledDistance());
        assertEquals(1, perfectCar.getGasLevel());

        try {
            perfectCar.move(2);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Not Enough Gas");
        }
    }
}