package ch7;

import java.util.HashSet;
import java.util.Set;

public class Ex3 {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        var result = new HashSet<T>(a.size() + b.size());
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        var result = new HashSet<T>(a.size() + b.size());
        result.addAll(a);
        result.retainAll(b);
        return result;
    }

    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        var result = new HashSet<T>(a.size() + b.size());
        result.addAll(a);
        result.removeAll(b);
        return result;
    }
}
