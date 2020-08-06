public class LC53_maxSubArray {
    /**
     * leetcode-53 最大自序和 【简单】
     * 基础的动态规划解法
     * 优秀题解：
     */

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}
