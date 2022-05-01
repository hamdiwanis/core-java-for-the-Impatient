package ch4;

public class Ex7 {
    public enum Colors {
        BLACK(0, 0, 0),
        RED(0, 0, 0),
        BLUE(0, 0, 0),
        GREEN(0, 0, 0),
        CYAN(0, 0, 0),
        MAGENTA(0, 0, 0),
        YELLOW(0, 0, 0),
        WHITE(0, 0, 0);

        private final int red, green, blue;

        Colors(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public int getRed() {
            return red;
        }

        public int getGreen() {
            return green;
        }

        public int getBlue() {
            return blue;
        }
    }
}
