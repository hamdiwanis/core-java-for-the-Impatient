package ch6;

import java.util.Arrays;

public class Ex20 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(repeat(3, 1, 2, 3)));
    }

    @SafeVarargs
    public static <T> T[] repeat(int n, T... objs) {
        @SuppressWarnings("unchecked") T[] result = (T[]) new Object[objs.length * n];

        for (int i = 0; i < result.length; i++) {
            result[i] = objs[i % objs.length];
        }

        return result;
    }

    @SafeVarargs
    public static <T> T[] repeat2(int n, T... objs) {
        @SuppressWarnings("unchecked") T[] result =
                (T[]) java.lang.reflect.Array.newInstance(objs.getClass().getComponentType(), n * objs.length);

        for (int i = 0; i < result.length; i++) {
            result[i] = objs[i % objs.length];
        }

        return result;
    }
}
