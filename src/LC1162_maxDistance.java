import java.util.LinkedList;
import java.util.Queue;

public class LC1162_maxDistance {
    /**
     * leetcode-1162 地图分析【中等】
     * 思路：使用BFS扩散，最后的步数就是最大的距离。
     * 优秀题解：https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/zhen-liang-yan-sou-huan-neng-duo-yuan-kan-wan-miao/
     */
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(i * N + j);
                }
            }
        }
        if (queue.size() == 0 || queue.size() == N * N) return -1;

        int step = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int index = queue.poll();
                int curX = index / N;
                int curY = index % N;
                for (int[] direction : directions) {
                    int xx = curX + direction[0];
                    int yy = curY + direction[1];
                    if (xx >= 0 && xx < N && yy >= 0 && yy < N && grid[xx][yy] == 0) {
                        grid[xx][yy] = 1;
                        queue.add(xx * N + yy);
                    }
                }
            }
            step++;
        }
        return step - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        LC1162_maxDistance ll = new LC1162_maxDistance();

        System.out.println(ll.maxDistance(grid));
    }
}
