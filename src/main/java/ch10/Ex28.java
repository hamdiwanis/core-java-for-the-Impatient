package ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Ex28 {
    static <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> cfs) {
        var res = new ArrayList<T>();
        for (var f : cfs) {
            try {
                res.add(f.get());
            } catch (Exception e) {
                res.add(null);
            }
        }
        return CompletableFuture.completedFuture(res);
    }
}
