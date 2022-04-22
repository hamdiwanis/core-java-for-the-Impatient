package ch2;

public class Ex4 {
    public static class IntHolder {
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public IntHolder(int value) {
            this.value = value;
        }
    }


    public static void swap(IntHolder int1, IntHolder int2) {
        int temp = int1.getValue();
        int1.setValue(int2.getValue());
        int2.setValue(temp);
    }
}
