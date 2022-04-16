package ch1;

import java.math.BigInteger;

public class Ex6 {
    public static BigInteger factorial(int n) {
        /*
        Recursive implementation

        if (n == 1 || n == 0) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n).multiply(factorial(n - 1));
         */

        var value = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            value = value.multiply(BigInteger.valueOf(i));
        }

        return value;
    }
}
