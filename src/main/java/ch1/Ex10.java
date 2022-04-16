package ch1;

import java.util.Random;

public class Ex10 {
    public static void main(String[] args) {
        var randomGenerator = new Random(System.currentTimeMillis());
        System.out.println(Long.toString(randomGenerator.nextLong(), 36));
    }
}
