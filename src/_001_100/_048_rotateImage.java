package _001_100;

public class _048_rotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };

        rotate(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; i + j < col; j++) {
                swapDiagonal(matrix, i, j, row - 1);
            }
        }

        for(int i = 0; i < row / 2; i++) {
            for(int j = 0; j < col; j++) {
                swapHorizontal(matrix, i, j, row - 1);
            }
        }
    }

    private static void swapHorizontal(int[][] matrix, int i, int j, int len) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[len - i][j];
        matrix[len - i][j] = temp;
    }

    private static void swapDiagonal(int[][] matrix, int i, int j, int len) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[len - j][len - i];
        matrix[len - j][len - i] = temp;
    }
}
