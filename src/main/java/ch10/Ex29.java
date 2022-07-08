package ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class Ex29 {
    public static <T> CompletableFuture<T> anyOf(List<Supplier<T>> actions, Executor exec) {
        var res = new CompletableFuture<T>();
        var actionResults = new ArrayList<CompletableFuture<T>>();

        for (var action : actions) {
            var actionResult = CompletableFuture.supplyAsync(action, exec);
            actionResults.add(actionResult);

            actionResult.whenComplete((value, throwable) -> {
                if (value != null) {
                    res.complete(value);
                    actionResults.forEach(cf -> cf.cancel(true));
                }
            });
        }

        CompletableFuture.allOf(actionResults.toArray(CompletableFuture[]::new)).whenCompleteAsync((v, t) -> {
            if (!res.isDone()) {
                res.completeExceptionally(new NoSuchElementException());
            }
        });

        return res;
    }
}
