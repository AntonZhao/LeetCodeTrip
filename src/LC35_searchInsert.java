public class LC35_searchInsert {
    // 二分查找
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (target > nums[right]) return nums.length;
        if (target < nums[left]) return 0;

        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    // 常规循环
    public int searchInsert_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                if (i == 0) return 0;
                return i;
            }
        }
        return nums.length;
    }
}
