public class MST0811_waysToChange {
    /**
     * leetcode-面试题08.11 硬币【中等】
     * 1.数学法，找到等查的规律
     * 2.动态规划-完全背包问题：完全背包问题即不限定硬币的个数地去组合硬币达到指定的值。
     * 优秀题解：
     */
    int mod = 1000000007;

    public int waysToChange(int n) {
        long sum = 0;
        for (int i = n; i >= 0; i = i - 25) {
            // 首项  remain / 5 + 1
            // 末项  (remain - remain / 10 * 10) / 5 + 1 = remain % 10 / 5 + 1
            // 项数  remain / 10 + 1
            long add = (long) (i / 5 + 1 + i % 10 / 5 + 1) * (i / 10 + 1) / 2;
            sum = (sum + add) % mod;
        }
        return (int) sum;
    }

    /**
     * for(int coin: coins) {
     * dp[k] += dp[k - coin];
     * }
     * 由于题意中要求对 1000000007求余。
     * 则：
     * for(int coin: coins) {
     * dp[k] = (dp[k] + dp[k - coin]) % 1000000007;
     * }
     */
    public int waysToChange_dp(int n) {
        int[] dp = new int[n + 1];
        int[] coins = {1, 5, 10, 25};

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        MST0811_waysToChange ll = new MST0811_waysToChange();
        System.out.println(ll.waysToChange(900750));
    }
}
