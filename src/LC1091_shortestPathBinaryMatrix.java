import java.util.LinkedList;
import java.util.Queue;

public class LC1091_shortestPathBinaryMatrix {
    //BFS
    private int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        // queue存的就是坐标
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currXY = queue.remove();
                // 到达终点
                if (currXY[0] == m - 1 && currXY[1] == n - 1) {
                    return res + 1;
                }
                // 八连通的找
                for (int j = 0; j < 8; j++) {
                    int nextX = direct[j][0] + currXY[0];
                    int nextY = direct[j][1] + currXY[1];
                    //  边界判断、是否被访问过、是否可以走
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                            && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
