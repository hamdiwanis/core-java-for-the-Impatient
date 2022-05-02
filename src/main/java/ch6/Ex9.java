package ch6;

import ch6.Ex7.Pair;

import java.util.ArrayList;

public class Ex9 {
    public static <E> Pair<E> firstLast(ArrayList<? extends E> list) {
        return new Pair<>(list.get(0), list.get(list.size() - 1));
    }
}
