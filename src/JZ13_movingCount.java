public class JZ13_movingCount {
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    public int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || k < sum(i) + sum(j) || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j)
                + dfs(i, j + 1);
    }

    private int sum(int num) {
//        计算数位之和
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
