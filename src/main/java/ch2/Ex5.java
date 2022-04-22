package ch2;

public class Ex5 {
    public static class Point {
        private double x;
        private double y;

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * @return x coordinates
         */
        public double getX() {
            return this.x;
        }

        /**
         * @return y coordinates
         */
        public double getY() {
            return this.y;
        }

        /**
         * translate the point in space
         *
         * @param dx offset in x direction
         * @param dy offset in y direction
         * @return new Point with the translated coordinates
         */
        public Point translate(double dx, double dy) {
            return new Point(this.x + dx, this.y + dy);
        }

        /**
         * scale the pont in space
         *
         * @param scale scale factor
         * @return new Point with the scaled coordinates
         */
        public Point scale(double scale) {
            return new Point(this.x * scale, this.y * scale);
        }
    }
}
