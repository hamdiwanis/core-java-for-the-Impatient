package ch5;

import java.math.BigInteger;

public class Ex11 {

    public static void main(String[] args) {
        factorial(5);
    }

    public static BigInteger factorial(int n) {
        if (n == 1 || n == 0) {
            return BigInteger.ONE;
        }

        System.out.println("-----------------------------------");
        for (var frame : new Exception().getStackTrace()) {
            System.out.println(frame);
        }

        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
}
