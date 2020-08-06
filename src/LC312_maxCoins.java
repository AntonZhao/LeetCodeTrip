public class LC312_maxCoins {

    /**
     * 终极解法  递归变递推
     */
    public static int maxCoins_final(int[] nums) {
        //避免空指针异常
        if (nums == null) {
            return 0;
        }

        //创建虚拟边界
        int length = nums.length;
        int[] nums2 = new int[length + 2];
        System.arraycopy(nums, 0, nums2, 1, length);
        nums2[0] = 1;
        nums2[length + 1] = 1;
        length = nums2.length;

        //创建dp表
        length = nums2.length;
        int[][] dp = new int[length][length];

        //开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
        for (int i = length - 2; i > -1; i--) {
            for (int j = i + 2; j < length; j++) {
                //维护一个最大值；如果i、j相邻，值为0
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length-1];
    }


    /**
     * 分治方法  DP
     */
    public int maxCoins2(int[] nums) {
        // 空数组处理
        if (nums == null) return 0;
        // 加虚拟边界
        int length = nums.length;
        int[] num2 = new int[length + 2];
        System.arraycopy(nums, 0, num2, 1, length);
        num2[0] = num2[length + 1] = 1;
        length += 2;
        // 创建缓存数组
        int[][] cache = new int[length][length];
        // 调用分治函数
        return maxCoin_dp(num2, length, 0, length - 1, cache);
    }

    private int maxCoin_dp(int[] nums, int length, int begin, int end, int[][] cache) {
        //回归条件，问题分解到最小子问题
        if (begin == end - 1) return 0;
        //缓存，避免重复计算
        if (cache[begin][end] != 0) return cache[begin][end];

        //维护一个最大值
        int max = 0;
        //状态转移方程 def( i, j ) = max { def( i , k ) + def( k , j )+nums[ i ][ j ][ k ] } | i<k<j
        for (int i = begin + 1; i < end; i++) {
            int temp = maxCoin_dp(nums, length, begin, i, cache)
                    + maxCoin_dp(nums, length, i, end, cache)
                    + nums[begin] * nums[i] * nums[end];
            max = temp > max ? temp : max;
        }
        cache[begin][end] = max;
        return max;
    }

    /**
     * 回溯方法 --- 超时
     */
    public int maxCoins1(int[] nums) {
        maxCoins_backtrack(nums, 0, 0);
        return maxCoinResult;
    }

    int maxCoinResult = -1;

    public void maxCoins_backtrack(int[] nums, int level, int beforeCoin) {
        // 回归条件
        if (level == nums.length) {
            maxCoinResult = Math.max(maxCoinResult, beforeCoin);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //略过已经戳破的气球
            if (nums[i] == -1) continue;

            // 记录当前的数值，然后使其失效
            int temp = nums[i];
            nums[i] = -1;

            //获取上一个气球的数字
            int preIndex = i - 1;
            int preNum = 0;
            while (preIndex >= 0 && nums[preIndex] == -1) preIndex--;
            preNum = preIndex < 0 ? 1 : nums[preIndex];

            //获取下一个气球的数字
            int nextIndex = i + 1;
            int nextNum = 0;
            while (nextIndex < nums.length && nums[nextIndex] == -1) nextIndex++;
            nextNum = nextIndex >= nums.length ? 1 : nums[nextIndex];

            //计算戳破当前气球的coin
            int currentCoin = beforeCoin + preNum * temp * nextNum;
            //递归进行下一戳
            maxCoins_backtrack(nums, i + 1, currentCoin);

            //回溯尝试其它戳法
            nums[i] = temp;
        }
    }
}
