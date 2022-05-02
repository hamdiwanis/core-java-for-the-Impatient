package ch6;

public class Ex5 {
    public static void main(String[] args) {
        Double[] result = Ex5.<Double>swap(0, 1, 1.5, 2.0, 3.0);
    }

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
}
