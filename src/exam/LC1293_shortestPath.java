package exam;

import java.util.LinkedList;
import java.util.Queue;

public class LC1293_shortestPath {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1)
            return 0;

        // 访问过的点，剩余的k
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = -1;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue.add(new Point(0,0,0)); // x y used_k 用过的k
        visited[0][0] = k;
        int minSteps = 0;
        while (!queue.isEmpty()) {
            minSteps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();
                int x = curr.x;
                int y = curr.y;
                int used_k = curr.oneCount;

                for (int j = 0; j < 4; j++) {
                    int new_x = x + dir[j][0];
                    int new_y = y + dir[j][1];
                    if (new_x == m - 1 && new_y == n - 1)
                        return minSteps;
                    if (new_x < 0 || new_x == m || new_y < 0 || new_y == n)
                        continue;
                    if (grid[new_x][new_y] == 1 && used_k >= k)
                        continue;

                    int new_used_k = grid[new_x][new_y] == 1 ? used_k + 1 : used_k;
                    if (visited[new_x][new_y] != -1 && visited[new_x][new_y] >= k - new_used_k) {
                        continue;
                    } else {
                        visited[new_x][new_y] = k - new_used_k;
                    }
//                    queue.add(new int[]{new_x, new_y, new_used_k});
                    queue.add(new Point(new_x, new_y, new_used_k));
                }
            }
        }
        return -1;
    }

    class Point {
        int x;
        int y;
        int oneCount;

        public Point(int x, int y, int oneCount) {
            this.x = x;
            this.y = y;
            this.oneCount = oneCount;
        }
    }

    public static void main(String[] args) {
        LC1293_shortestPath ll = new LC1293_shortestPath();
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};
        System.out.println(ll.shortestPath(grid, 1));
    }
}
