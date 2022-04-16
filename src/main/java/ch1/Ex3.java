package ch1;

public class Ex3 {
    public static int findLargest(int number1, int number2, int number3) {
        /*
        Only conditional operators implementation

        int largest = number1;

        if (number2 > number1) {
            largest = number2;
        }

        if (number3 > largest) {
            largest = number3;
        }

        return largest;

        */

        return Math.max(Math.max(number1, number2), number3);
    }
}
