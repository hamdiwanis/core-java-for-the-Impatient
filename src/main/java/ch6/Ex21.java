package ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex21 {
    public static void main(String[] args) {
        List<String>[] result = construct(3);
        System.out.println(Arrays.toString(result));
    }

    @SafeVarargs
    public static <T> T[] construct(int size, T... typeListCapture) {
        var list = new ArrayList<T>(size);

        for (int i = 0; i < size; i++) {
            list.add(null);
        }

        return list.toArray(typeListCapture);
    }
}
