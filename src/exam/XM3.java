package exam;

import java.util.Scanner;

public class XM3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        char[][] grid = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        if (word.equals("")) {
            System.out.println(false);
        } else {
            System.out.println(solve(grid, word.trim()));
        }

        scanner.close();
    }

    static int[][] d4 = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean solve(char[][] grid, String word) {
        if (grid.length == 0 || grid[0].length == 0)
            return false;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(i, j, 0, visited, grid, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int x, int y, int count, boolean[][] visited, char[][] grid, String word) {
        if (count == word.length() - 1)
            return grid[x][y] == word.charAt(word.length() - 1);

        if (grid[x][y] == word.charAt(count)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int new_x = x + d4[i][0];
                int new_y = y + d4[i][1];
                if (new_x >= 0 && new_x < grid.length && new_y >= 0 && new_y < grid[0].length
                        && visited[new_x][new_y] == false) {
                    if (dfs(new_x, new_y, count + 1, visited, grid, word))
                        return true;
                }
            }
            visited[x][y] = false;
        }

        return false;
    }
}
