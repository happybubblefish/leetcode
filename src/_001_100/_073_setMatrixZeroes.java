package _001_100;

public class _073_setMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        setZeroes(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0){
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] rowIndictor = new boolean[rows];
        boolean[] colIndicator = new boolean[cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    rowIndictor[i] = true;
                    colIndicator[j] = true;
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(rowIndictor[i] || colIndicator[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
