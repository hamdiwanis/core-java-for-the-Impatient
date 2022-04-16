package ch1;

import java.util.Arrays;

public class Ex14 {
    public static boolean isMagicSquare(int[][] matrix) {
        // check if square
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int sideDimension = matrix.length;
        Integer magicSum = null;

        var columnsSum = new int[sideDimension];
        Arrays.fill(columnsSum, 0);

        int mainDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < sideDimension; i++) {
            int currentRowSum = 0;
            for (int j = 0; j < sideDimension; j++) {
                currentRowSum += matrix[i][j];
                columnsSum[i] += matrix[j][i];

                if (i == j) {
                    mainDiagonalSum += matrix[j][i];
                }

                if (j == sideDimension - i - 1) {
                    secondaryDiagonalSum += matrix[j][i];
                }
            }

            if (magicSum == null) {
                magicSum = currentRowSum;
            } else if (!magicSum.equals(currentRowSum)) {
                return false;
            } else {
                magicSum = currentRowSum;
            }
        }

        for (int columnSum : columnsSum) {
            if (!magicSum.equals(columnSum)) {
                return false;
            }
        }

        return magicSum.equals(mainDiagonalSum) && magicSum.equals(secondaryDiagonalSum);
    }
}
