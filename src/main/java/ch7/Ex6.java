package ch7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex6 {
    public static void main(String[] args) {
        test(new HashMap<String, HashSet<Integer>>());
    }

    public static <T extends Set<Integer>> void test(Map<String, T> param) {
    }
}
