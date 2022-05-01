package ch2;

import java.util.List;
import java.util.Random;

public class Ex10 {
    public static class RandomNumbers {
        static final Random randomGenerator = new Random(System.currentTimeMillis());

        public static int randomElement(int[] list) {
            if (list.length == 0) return 0;

            int index = randomGenerator.nextInt(list.length);
            return list[index];
        }

        public static int randomElement(List<Integer> list) {
            if (list.isEmpty()) return 0;

            int index = randomGenerator.nextInt(list.size());
            return list.get(index);
        }
    }
}
