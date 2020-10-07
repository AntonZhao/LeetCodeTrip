public class LCP19_minimumOperations {
    /**
     * https://leetcode-cn.com/problems/UlBDOe/solution/java-quan-zhu-shi-li-jie-dong-tai-gui-hua-by-leetc/
     */
    public int minimumOperations(String leaves) {
        if (leaves == null || leaves.length() == 0)
            return 0;
        char[] chars = leaves.toCharArray();
        int len = chars.length;
        /*
            状态数组，state[i][j]中：
                i表示终止下标
                j表示：0为左半边，1为中间部分，2为右半边
            state[i][j] 表示 从0到i需要调整的叶子数
         */
        int[][] dp = new int[len][3];
        dp[0][0] = chars[0] == 'r' ? 0 : 1;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            int isY = chars[i] == 'y' ? 1 : 0;
            dp[i][0] = dp[i - 1][0] + isY;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (1 - isY);
            if (i > 1)
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isY;
        }

        return dp[len - 1][2];
    }
}
