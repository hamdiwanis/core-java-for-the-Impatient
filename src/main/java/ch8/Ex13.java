package ch8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Ex13 {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        final var firstIterator = first.iterator();
        final var secondIterator = second.iterator();

        AtomicInteger index = new AtomicInteger(0);

        return Stream.iterate(
                (T) null,
                t -> t != null || firstIterator.hasNext() || secondIterator.hasNext(),
                t -> {
                    if ((index.getAndIncrement() % 2) == 0) {
                        return firstIterator.hasNext() ? firstIterator.next() : null;
                    } else {
                        return secondIterator.hasNext() ? secondIterator.next() : null;
                    }
                }).skip(1);
    }
}
