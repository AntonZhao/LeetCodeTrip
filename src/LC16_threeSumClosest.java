import java.util.Arrays;

public class LC16_threeSumClosest {
    /**
     * leetcode-16 最接近的三数之和【中等】
     * 思路：双指针。先将数组排序，然后固定一个点，设置好头和尾，按照大小比对进行移动。
     * 优秀题解：都不错
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
