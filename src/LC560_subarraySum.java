import java.util.HashMap;
import java.util.Map;

public class LC560_subarraySum {
    /**
     * leetcode-560 和为K的子数组 【中等】
     * 只说最优的方法：
     *  1. 当前的pre是从0到当前下标位置的和
     *  2. 通过(pre - k)去前面看看是否出现过，这个操作通过hashmap实现，从而简化时间复杂度。
     * 优秀题解：
     */

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
//            if (map.containsKey(pre - k)) {
//                count += map.get(pre - k);
//            }
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0));
        }
        return count;
    }

    // 前缀法-复杂版
    public int subarraySum_prefix_nn(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                if (preSum[right + 1] - preSum[left] == k)
                    count++;
            }
        }

        return count;
    }

    public int subarraySum_nn(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            if (sum == k)
                res++;
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum == k)
                    res++;
            }
        }
        return res;
    }
}
