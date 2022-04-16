package ch1;

public class Ex7 {
    public static int unsignedSum(int number1, int number2) {
        return number1 + number2;
    }

    public static int unsignedDifference(int number1, int number2) {
        return number1 - number2;
    }

    public static int unsignedProduct(int number1, int number2) {
        return number1 * number2;
    }

    public static int unsignedQuotient(int number1, int number2) {
        return Integer.divideUnsigned(number1, number2);
    }

    public static int unsignedRemainder(int number1, int number2) {
        return Integer.remainderUnsigned(number1, number2);
    }
}
