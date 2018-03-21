package _001_100;

public class _063_uniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        obstacleGrid[0][0] = 1;

        for(int i = 1; i < rows; i++) {
            if(obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                continue;
            }

            obstacleGrid[i][0] += obstacleGrid[i - 1][0];
        }

        for(int i = 1; i < cols; i++) {
            if(obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
                continue;
            }

            obstacleGrid[0][i] += obstacleGrid[0][i - 1];
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[rows - 1][cols - 1];
    }
}
