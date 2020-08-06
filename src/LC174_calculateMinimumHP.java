import java.util.Arrays;

public class LC174_calculateMinimumHP {
    /**
     * 如果按照从左上往右下的顺序进行动态规划，我们无法直接确定到达(1,2) 的方案，因为有两个重要程度相同的参数同时影响后续的决策。
     * 也就是说，这样的动态规划是不满足「无后效性」的。
     *
     * 这种情况，是不是反过来，就变成了有后效性？
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[n][m - 1] = dp[n - 1][m] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        LC174_calculateMinimumHP ll = new LC174_calculateMinimumHP();
        int[][] nums = {{-2, -3, -3}, {-5, -10, 1}, {10, 30, -5}};
        int[][] nums2 = {{0, -3}};
        System.out.println(ll.calculateMinimumHP(nums2));
    }

}
