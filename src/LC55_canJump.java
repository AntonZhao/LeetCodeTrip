public class LC55_canJump {
    /**
     * leetcode-55 跳跃游戏【中等】
     * 1.暴力方法：两个循环，最慢的方法
     * 2.贪心法？
     * 优秀题解：
     */
    // 贪心
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        if (nums.length < 2) return true;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > maxPos) return false;
            maxPos = Math.max(maxPos, i + nums[i]);
        }
        return maxPos >= nums.length - 1;
    }
    public boolean canJump_r(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    // 比较慢的方法，O(n*n)
    public boolean canJump_nn(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 1) return true;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (dp[i] == true) {
                for (int j = 0; j <= nums[i]; j++) {
                    if (i + j == nums.length - 1)
                        return true;
                    if (i + j < nums.length)
                        dp[i + j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nn = {9, 4, 2, 1, 0, 2, 0};
        LC55_canJump ll = new LC55_canJump();
        System.out.println(ll.canJump(nn));
    }
}
