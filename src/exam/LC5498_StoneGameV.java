package exam;

import java.util.HashMap;

public class LC5498_StoneGameV {
    /**
     * 还没完全懂
     */
    public int stoneGameV(int[] stoneValue) {
        int N = stoneValue.length;
        int[][] dp = new int[N][N];

        // 前缀和
        int[] preSum = new int[N];
        preSum[0] = stoneValue[0];
        for (int i = 1; i < stoneValue.length; i++) {
            preSum[i] = preSum[i - 1] + stoneValue[i];
        }

        // 区间dp
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;
                for (int m = i; m <= j; m++) {
                    if (i > m || m + 1 > j) continue;
                    // 左区间 和 右区间
                    int left = dp[i][m];
                    int right = dp[m + 1][j];
                    int leftSum = preSum[m] - (i > 0 ? preSum[i - 1] : 0);
                    int rightSum = preSum[j] - preSum[m];

                    //case 1: Alice决定丢那行
                    if (leftSum == rightSum) {
                        int score = Math.max(left, right) + leftSum;
                        dp[i][j] = Math.max(dp[i][j], score);
                    }
                    //case 2: Bob丢掉最大的，Alice只能选剩下的
                    else {
                        if (leftSum > rightSum) {
                            dp[i][j] = Math.max(dp[i][j], right + rightSum);
                        } else {
                            dp[i][j] = Math.max(dp[i][j], left + leftSum);
                        }
                    }
                }
            }
        }
        return dp[0][N - 1];
    }
}
