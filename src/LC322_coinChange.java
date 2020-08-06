public class LC322_coinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange_iterative(coins, 11));
    }

    /**
     * DP: F(S) = F(S - C) + 1
     * DP: F(S) = min( F(S - C), for C in [C0,C1.....]) + 1
     * Suppose we have already computed all the minimum counts up to sum,
     * what would be the minimum count for sum+1?
     */
    public static int coinChange_iterative(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    // 带备忘录的递归
    public int coinChange_recursion(int[] coins, int amount) {
        return _coinChange(coins, amount, new int[amount]);
    }

    private int _coinChange(int[] coins, int remain, int[] memo) {
        if (remain == 0) return 0;
        if (remain < 0) return -1;
        if (memo[remain - 1] != 0) return memo[remain - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = _coinChange(coins, remain - coin, memo);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        memo[remain - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[remain - 1];
    }


}
