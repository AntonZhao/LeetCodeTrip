package exam;

public class LC1292_maxSideLength {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[310][310];
        int[][] rs = new int[310][310];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                rs[i][j] = rs[i][j - 1] + mat[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + rs[i][j];
            }
        }
        int ans = 0;
        for (ans = Math.min(m, n); ans >= 1; ans--) {
            for (int i = 1; i + ans - 1 <= m; i++) {
                for (int j = 1; j + ans - 1 <= n; j++) {
                    int v = sum[i + ans - 1][j + ans - 1] - sum[i - 1][j + ans - 1] - sum[i + ans - 1][j - 1] + sum[i - 1][j - 1];
                    if (v <= threshold)
                        return ans;
                }
            }
        }
        return ans;
    }
}
