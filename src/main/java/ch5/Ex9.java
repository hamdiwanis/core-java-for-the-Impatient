package ch5;

import java.util.concurrent.locks.ReentrantLock;

public class Ex9 {
    public static void main(String[] args) {
        try (var lock = createCloseableLock()) {
            // will handel unlock
        }
    }

    public static AutoCloseableLock createCloseableLock() {
        var lock = new AutoCloseableLock();
        lock.lock();
        return lock;
    }

    public static class AutoCloseableLock extends ReentrantLock implements AutoCloseable {
        @Override
        public void close() {
            this.unlock();
        }
    }
}
