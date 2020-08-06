public class LC63_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;

        int[] dp = new int[cols];
        dp[0] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[cols - 1];
    }

    public static int uniquePathsWithObstacles_nn(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1)
            return 0;

        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }

        for (int j = 1; j < cols; ++j) {
            if (obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (obstacleGrid[i - 1][j] == 1) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (obstacleGrid[i][j - 1] == 1) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] ob = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    }
}
