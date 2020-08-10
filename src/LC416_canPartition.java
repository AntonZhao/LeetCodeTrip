import java.util.HashMap;

public class LC416_canPartition {
    /**
     * leetcode-416 分割等和子集 【中等】
     * 01背包 --- 动态规划
     *
     * 状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
     * 分类讨论状态转移：
     *      1. 不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
     *      2、选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。
     * 状态转移方程是：
     *      dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
     */

    public boolean canPartition_1d(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if (sum % 2 != 0) return false;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target)  dp[nums[0]] = true;
        // 第一个物品不选择装的情况
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[target]) return true;
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }

    public boolean canPartition_2d(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if (sum % 2 != 0) return false;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target)  dp[0][nums[0]] = true;
        // 第一个物品不选择装的情况
        dp[0][0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (j == nums[i]) {
                    dp[i][j] = true;
                    continue;
                }

                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

                // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
                if (dp[i][target] == true) {
                    return true;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        LC416_canPartition ll = new LC416_canPartition();

//        int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 5};
        System.out.println(ll.canPartition_1d(nums));
    }
}
