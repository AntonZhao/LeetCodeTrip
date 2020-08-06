import java.util.Arrays;

public class minCost265 {
    public int minCostII_youhua(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];

        for (int i = 1; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < k; ++i) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; ++i) {
            // min1 表示的是最大值，min2 表示的是次大值
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int l = 0; l < k; ++l) {
                if (min1 > dp[i - 1][l]) {
                    min2 = min1;
                    min1 = dp[i - 1][l];
                    minIndex = l;
                } else if (min2 > dp[i - 1][l]) {
                    min2 = dp[i - 1][l];
                }
            }

            for (int j = 0; j < k; ++j) {
                if (minIndex != j) {
                    dp[i][j] = Math.min(dp[i][j], min1 + costs[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], min2 + costs[i][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; ++i) {
            result = Math.min(result, dp[n - 1][i]);
        }

        return result;
    }

    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];

        for (int i = 1; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < k; ++i) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < k; ++j) {
                for (int m = 0; m < k; ++m) {
                    if (m != j) {
                        dp[i][m] = Math.min(dp[i][m], dp[i - 1][j] + costs[i][m]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; ++i) {
            result = Math.min(result, dp[n - 1][i]);
        }

        return result;
    }
}
