package exam;

import java.util.HashSet;

public class LC5482_containsCycle {

    int[][] direct = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean containsCycle(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false) {
                    if (dfs(grid, visited, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int row, int col, int prevRow, int prevCol) {

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int x = row + direct[i][0];
            int y = col + direct[i][1];

            if (x == prevRow && y == prevCol)
                continue;
            if (isValid(grid, x, y) && grid[x][y] == grid[row][col]) {
                if (visited[x][y])
                    return true;
                if (dfs(grid, visited, x, y, row, col))
                    return true;
            }
        }
        return false;
    }

    boolean isValid(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return false;
        return true;
    }

    public static void main(String[] args) {
        LC5482_containsCycle ll = new LC5482_containsCycle();
//        char[][] grid = new char[][]{{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        char[][] grid = new char[][]{{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        System.out.println(ll.containsCycle(grid));
    }
}
