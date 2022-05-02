package ch6;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex19 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(repeat(10, 4)));
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(obj);
        return (T[]) result.toArray();
    }
}
