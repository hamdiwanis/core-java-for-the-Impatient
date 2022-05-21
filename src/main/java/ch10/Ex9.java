package ch10;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Ex9 {
    public static void main(String[] args) throws InterruptedException {
        {
            long start = System.currentTimeMillis();
            counterWithAtomicLong();
            long end = System.currentTimeMillis();

            System.out.println("counterWithAtomicLong: " + (end - start));
        }

        {
            long start = System.currentTimeMillis();
            counterWithLongAdder();
            long end = System.currentTimeMillis();

            System.out.println("counterWithLongAdder: " + (end - start));
        }
    }

    public static void counterWithAtomicLong() throws InterruptedException {
        AtomicLong counter = new AtomicLong(0);

        var runnersList = new ArrayList<Thread>(1000);

        for (int i = 0; i < 1000; i++) {
            var runner = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    counter.getAndIncrement();
                }
            });
            runner.start();
            runnersList.add(runner);
        }

        for (var runner : runnersList) {
            runner.join();
        }
    }

    public static void counterWithLongAdder() throws InterruptedException {
        LongAdder counter = new LongAdder();

        var runnersList = new ArrayList<Thread>(1000);

        for (int i = 0; i < 1000; i++) {
            var runner = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    counter.increment();
                }
            });
            runner.start();
            runnersList.add(runner);
        }

        for (var runner : runnersList) {
            runner.join();
        }
    }
}
