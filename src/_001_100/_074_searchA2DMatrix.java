package _001_100;

public class _074_searchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 9, 11, 13, 15 },
                { 17, 19, 21, 23 },
                { 25, 27, 29, 31 }
        };

        System.out.println(searchMatrix(matrix, 19));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        if(matrix[0][0] > target || matrix[rows - 1][cols - 1] < target) {
            return false;
        }

        int startRow = 0;
        int endRow = rows - 1;

        while(startRow <= endRow) {
            int mid = startRow + (endRow - startRow) / 2;

            if(matrix[mid][cols - 1] == target) {
                return true;
            } else if (matrix[mid][cols - 1] < target) {
                startRow = mid + 1;
            } else {
                endRow = mid - 1;
            }
        }

        startRow = startRow < 0 ? 0 : startRow;

        int startCol = 0;
        int endCol = cols - 1;

        while(startCol <= endCol) {
            int mid = startCol + (endCol - startCol) / 2;

            if(matrix[startRow][mid] == target) {
                return true;
            } else if (matrix[startRow][mid] < target) {
                startCol = mid + 1;
            } else {
                endCol = mid - 1;
            }
        }

        return false;
    }
}
