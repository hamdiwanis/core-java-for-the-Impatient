package ch3;

public class Ex9 {
    public static void main(String[] args) {
        new Thread(new Greeter(3, "Target 1")).start();
        new Thread(new Greeter(3, "Target 2")).start();
    }


    public static class Greeter implements Runnable {
        private final int n;
        private final String target;

        public Greeter(int n, String target) {
            this.n = n;
            this.target = target;
        }

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                System.out.println("Hello, " + target);
            }
        }
    }
}
