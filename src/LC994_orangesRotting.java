import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LC994_orangesRotting {
    public int orangesRotting(int[][] grid) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int rows = grid.length, cols = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    int temp = i * cols + j;
                    queue.offer(temp);
                    map.put(temp, 0);
                }
            }
        }

        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                map.put(cur, map.get(cur) + 1);
                int row = cur / cols;
                int col = cur % cols;

                for (int j = 0; j < 4; j++) {
                    int xx = row + dx[j], yy = col + dy[j];
                    if (xx >= 0 && xx < rows && yy >= 0 && yy < cols && grid[xx][yy] == 1) {
                        grid[xx][yy] = 2;
                        int temp = xx * cols + yy;
                        queue.offer(temp);
                        map.put(temp, map.get(cur));
                        res = map.get(cur);
                    }
                }
            }
        }
        for (int[] nums : grid) {
            for (int num : nums)
                if (num == 1)
                    return -1;
        }

        return res;
    }

    public static void main(String[] args) {
        LC994_orangesRotting ll = new LC994_orangesRotting();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(ll.orangesRotting(grid));
    }
}
