public class LC64_minPathSum {
    /**
     * 64. 最小路径和 难度:中等
     * 原地DP破之
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 1; i < rows; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < cols; i++) grid[0][i] += grid[0][i - 1];

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);

        return grid[rows - 1][cols - 1];
    }
}
