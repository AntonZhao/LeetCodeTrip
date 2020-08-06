public class LC123_maxProfitIII {
    /**
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     */
    public int maxProfit_k_2(int[] prices) {
        if (prices.length == 0) return 0;

        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i == 0) {
                    // 处理 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

                System.out.println("i = " + i + ", k = " + k + ", 卖出后 dp = " + dp[i][k][0]);
                System.out.println("i = " + i + ", k = " + k + ", 买入后 dp = " + dp[i][k][1]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        LC123_maxProfitIII ll = new LC123_maxProfitIII();
        int[] ps = {3, 3, 5, 0, 0, 3, 1, 4};
        ll.maxProfit_k_2(ps);
    }
}
