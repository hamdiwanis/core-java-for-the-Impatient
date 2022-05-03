package ch6;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class Ex22 {
    public static <V, T extends Throwable> V doWork(Callable<V> c, Function<Throwable, T> exConstructor) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            throw exConstructor.apply(realEx);
        }
    }
}
