package ch3;

public class Ex14 {
    public static Runnable runInOrder(Runnable[] tasks) {
        return () -> {
            for (Runnable task : tasks) {
                task.run();
            }
        };
    }
}
