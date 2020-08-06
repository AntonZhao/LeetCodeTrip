import java.util.Arrays;

public class LC198_rob {
    /**
     * F(i): 这天必偷的最大值
     * DP: F(i) = max( f(i - 1), f(i - 2) + nums[i - 1])
     */
    //二维DP
    public int rob_2(int[] nums) {
        if (nums == null || nums.length == 1) return 0;

        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // 一维DP
    public int rob_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int max = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            // 今天偷(nums[i-1] + dp[i - 2])   今天不偷(dp[i - 1])
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // 至尊DP
    public int rob_clean(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int currMax = 0, preMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(x + preMax, currMax);
            preMax = temp;
        }
        return currMax;
    }

    // 暴力递归  TLE
    public int rob_recursion(int[] nums) {
        return _rob(0, nums);
    }

    private int _rob(int idx, int[] nums) {
        if (idx > nums.length - 1) return 0;

        return Math.max(_rob(idx + 1, nums), _rob(idx + 2, nums) + nums[idx]);
    }

    //超时问题可以使用备忘录解决
    private int[] memo;

    // 主函数
    public int rob(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0);
    }

    // 返回 dp[start..] 能抢到的最大值
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1) return memo[start];

        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }
}
