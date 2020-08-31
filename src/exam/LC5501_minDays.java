package exam;

public class LC5501_minDays {
    public int minDays(int[][] grid) {
        int num = getLandNum(grid);
        if (num > 1) return 0;
        if (num == 1) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        if (getLandNum(grid) > 1) {
                            return 1;
                        }
                        grid[i][j] = 1;
                    }
                }
            }
        }
        return 2;
    }

    private int getLandNum(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    dfs(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length)
            return;
        if (grid[row][col] != 1 || visited[row][col] == true)
            return;

        int[][] d4 = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[row][col] = true;
        for (int i = 0; i < d4.length; i++) {
            int x = row + d4[i][0];
            int y = col + d4[i][1];
            dfs(grid, visited, x, y);
        }
    }

    public static void main(String[] args) {
        LC5501_minDays ll = new LC5501_minDays();

        int[][] grid = new int[][]{{1,1}, {1,1}};

        System.out.println(ll.minDays(grid));
    }
}
