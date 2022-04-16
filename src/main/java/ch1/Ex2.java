package ch1;

public class Ex2 {
    public static int normalizeDegree(int degree) {
        // Modules implementation
        // return ((degree % 360) + 360) % 360;
        
        return Math.floorMod(degree, 360);
    }
}
