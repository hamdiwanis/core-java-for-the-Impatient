package ch1;

public class Ex4 {
    public static double[] smallestAndLargestPositiveDoubleValues() {
        return new double[]{Math.nextUp(0.0), Math.nextDown(Double.POSITIVE_INFINITY)};
    }
}
