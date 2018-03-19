package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _059_spiralMatrixII {
    public static void main(String[] args) {
        int[][] res = generateMatrix(5);

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(res[i][j]);
            }

            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        if(n <= 0) {
            return matrix;
        }

        int beginRow = 0;
        int endRow = n - 1;
        int beginCol = 0;
        int endCol = n - 1;
        int index = 1;

        while (beginRow <= endRow && beginCol <= endCol) {
            for(int i = beginCol; i <= endCol; i++) {
                matrix[beginRow][i] = index++;
            }

            beginRow++;

            for(int i = beginRow; i <= endRow; i++) {
                matrix[i][endCol] = index++;
            }

            endCol--;


            if(endRow >= beginRow) {
                for(int i = endCol; i >= beginCol; i--) {
                    matrix[endRow][i] = index++;
                }
            }

            endRow--;

            if(endCol >= beginCol) {
                for(int i = endRow; i >= beginRow; i--) {
                    matrix[i][beginCol] = index++;
                }
            }

            beginCol++;
        }

        return matrix;
    }
}
