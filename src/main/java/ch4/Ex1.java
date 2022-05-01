package ch4;

import java.util.Objects;

public class Ex1 {
    public static class Point {
        protected double x, y;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            LabeledPoint that = (LabeledPoint) o;
            return Objects.equals(label, that.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), label);
        }

        @Override
        public String toString() {
            return "LabeledPoint{" +
                    "label='" + label + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
