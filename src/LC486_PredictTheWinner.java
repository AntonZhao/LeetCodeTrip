public class LC486_PredictTheWinner {

    /**
     * 动态规划
     *
     * 甲乙比赛，甲先手面对区间[i...j]时，dp[i][j]表示甲对乙的净胜分。
     * 最终求的就是，甲先手面对区间[0...n-1]时，甲对乙的净胜分dp[0][n-1]是否>=0。
     * 甲先手面对区间[i...j]时，
     *  如果甲拿nums[i]，那么变成乙先手面对区间[i+1...j]，这段区间内乙对甲的净胜分为dp[i+1][j]；那么甲对乙的净胜分就应该是nums[i] - dp[i+1][j]。
     *  如果甲拿nums[j]，同理可得甲对乙的净胜分为是nums[j] - dp[i][j-1]。
     * 以上两种情况二者取大即可。
     */
    public boolean PredictTheWinner_dp(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }

    /**
     * 递归
     */
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }

}
