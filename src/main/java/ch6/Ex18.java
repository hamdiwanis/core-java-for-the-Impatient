package ch6;

import java.util.function.IntFunction;

public class Ex18 {
    public static void main(String[] args) {
        repeat(10, 42, Integer[]::new);
    }

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i++) result[i] = obj;
        return result;
    }
}
