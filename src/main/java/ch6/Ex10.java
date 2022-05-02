package ch6;

public class Ex10 {
    public static void main(String[] args) {
        System.out.println(min(new Integer[]{1, 2, 3, 4}));
        System.out.println(max(new Integer[]{1, 2, 3, 4}));
    }

    public static <E extends Comparable<? super E>> E min(E[] list) {
        if (list.length < 1) return null;

        E minValue = list[0];

        for (var item : list) {
            if (item.compareTo(minValue) < 0) {
                minValue = item;
            }
        }

        return minValue;
    }

    public static <E extends Comparable<? super E>> E max(E[] list) {
        if (list.length < 1) return null;

        E maxValue = list[0];

        for (var item : list) {
            if (maxValue.compareTo(item) < 0) {
                maxValue = item;
            }
        }

        return maxValue;
    }
}
