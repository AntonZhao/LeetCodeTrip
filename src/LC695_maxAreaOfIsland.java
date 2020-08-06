public class LC695_maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            ans += dfs(grid, row + di[i], col + dj[i]);
        }
        return ans;
    }
}
