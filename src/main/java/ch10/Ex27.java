package ch10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class Ex27 {
    public static <T> CompletableFuture<T> supplyAsync(Supplier<T> action, Executor exec) {
        var res = new CompletableFuture<T>() {
            private volatile Thread thread;

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                if (mayInterruptIfRunning && thread != null) {
                    thread.interrupt();
                }
                return super.cancel(mayInterruptIfRunning);
            }
        };

        exec.execute(() -> {
            res.thread = Thread.currentThread();
            try {
                T result = action.get();
                res.complete(result);
            } catch (Exception e) {
                res.completeExceptionally(e);
            }
        });

        return res;
    }
}
