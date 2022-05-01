package ch4;

public class Ex1 {
    public static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    public static class LabeledPoint extends Point {
        private String label;

        public LabeledPoint(String label, double x, double y) {
            super(x, y);
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
