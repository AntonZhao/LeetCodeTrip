package exam;

public class LC5491_diagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int res = 0;

        if (n == 1) return mat[0][0];

        for (int i = 0; i < n; i++) {
            res += mat[i][i];
        }
        for (int i = 0; i < n; i++) {
            res += mat[i][n - i - 1];
        }

        if (n % 2 == 0) {
            return res;
        } else {
            return res - mat[n / 2][n / 2];
        }
    }
}
