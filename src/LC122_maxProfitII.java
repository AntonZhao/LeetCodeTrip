/**
 * 122. 买卖股票的最佳时机2
 */
public class LC122_maxProfitII {
    /**
     * 1 是 买入股票， 0 是 卖出股票
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *             = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
     *
     * 我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     */
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

    // 峰谷法
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peek = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            // get valley
            while (i < prices.length - 1 && prices[i] > prices[i + 1])
                i++;
            valley = prices[i];
            //get peek
            while (i < prices.length - 1 && prices[i] < prices[i + 1])
                i++;
            peek = prices[i];
            maxprofit += peek - valley;
        }
        return maxprofit;
    }
}