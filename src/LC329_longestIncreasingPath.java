import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LC329_longestIncreasingPath {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;

        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(i, j, matrix, cache));
            }
        }
    
        return res;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] cache) {
        if (cache[row][col] != 0) return cache[row][col];

        for (int i = 0; i < 4; i++) {
            int x = row + dx[i], y = col + dy[i];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
                continue;
            }
            if (matrix[x][y] > matrix[row][col]) {
                cache[row][col] = Math.max(cache[row][col], dfs(x, y, matrix, cache));
            }
        }
        return ++cache[row][col];
    }

    public static void main(String[] args) {
        LC329_longestIncreasingPath ll = new LC329_longestIncreasingPath();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(ll.longestIncreasingPath(matrix));

        int num = 0;
        System.out.println(func(num));
        num = 0;
        System.out.println(func2(num));

        ArrayList<Integer> arr = new ArrayList<>();

        AtomicInteger a = new AtomicInteger(1);
        a.incrementAndGet();
    }

    static int func(int i) {
        return i++;
    }

    static int func2(int i) {
        return ++i;
    }
}
