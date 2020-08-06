public class LC188_maxProfitIV {
    /**
     * 1 是 持有股票， 0 是 卖出股票
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k - 1][0] - prices[i])
     *
     *
     * 一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，
     * 如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
     */
    public int maxProfit_k_given(int k_given, int[] prices) {
        if (prices.length == 0) return 0;

        int max_k = k_given;
        int n = prices.length;
        if (max_k > n / 2)
            return maxProfit_k_infinity(prices);

        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    public int maxProfit_k_infinity(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
