package ch6;

import java.util.ArrayList;
import java.util.function.Function;

public class Ex15 {
    protected static <T, R> ArrayList<R> map(ArrayList<T> list, Function<T, R> mapper) {
        var mappedList = new ArrayList<R>(list.size());

        for (var item : list) {
            mappedList.add(mapper.apply(item));
        }

        return mappedList;
    }
}
