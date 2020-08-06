//https://mp.weixin.qq.com/s/RPBRysbX7wgW_vnPNqloYA
public class minCost256 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;

        int[][] dp = new int[n][3];

        for (int i = 0; i < costs[0].length; ++i) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
