package ch10;

import java.util.Arrays;

public class Ex4 {
    public static int parallelFibonacci(int n) {
        if (n == 0 || n == 1) return n;

        var factors = new Matrix[n];
        Arrays.parallelSetAll(factors, (i) -> new Matrix(new int[][]{{1, 1}, {1, 0}}));
        Arrays.parallelPrefix(factors, Matrix::multiply);

        return factors[n - 1].get(0, 1);
    }

    public static class Matrix {
        private final int[][] value;

        public Matrix(int[][] value) {
            this.value = value;
        }

        public int get(int i, int j) {
            return value[i][j];
        }

        public int height() {
            return this.value.length;
        }

        public int width() {
            return this.value[0] != null ? this.value[0].length : 0;
        }

        public Matrix multiply(Matrix m) {
            if (m == null || m.value == null || m.width() != m.height()) {
                throw new IllegalArgumentException();
            }

            var resultHeight = this.height();
            var resultWidth = m.width();

            var res = new int[resultHeight][resultWidth];

            for (int i = 0; i < resultHeight; i++) {
                var valueRow = this.value[i];

                for (int j = 0; j < resultWidth; j++) {
                    var newCellValue = 0;
                    for (int k = 0; k < valueRow.length; k++) {
                        newCellValue += valueRow[k] * m.get(k, j);
                    }

                    res[i][j] = newCellValue;
                }
            }

            return new Matrix(res);
        }
    }
}
