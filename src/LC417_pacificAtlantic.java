import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC417_pacificAtlantic {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int m, n;
    private int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if ((m = matrix.length) == 0) return res;
        if ((n = matrix[0].length) == 0) return res;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        this.matrix = matrix;

        // 这里已经开始从边界走了
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }

        return res;
    }

    // 换一种思路，从边界往里面走，只能走到比自己更高或者等高的地方。边界能走到的地方，就是能流入对应海洋的地方。
    private void dfs(int x, int y, boolean[][] canReach) {
        canReach[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if (isIn(new_x, new_y) && matrix[x][y] <= matrix[new_x][new_y] && !canReach[new_x][new_y]) {
                dfs(new_x, new_y, canReach);
            }
        }
    }

    private boolean isIn(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
