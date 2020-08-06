public class LC33_search {
    /**
     * leetcode-33 33. 搜索旋转排序数组 【中等】
     * 要求时间复杂度O(logN)，所以肯定是二分了，但这个二分不简单啊。。
     * mid 有两种情况分别是
     *      hhhhhhhlll   |    hhhllllllll
     * 剩下自己脑补
     * 优秀题解：
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target)
                return mid;
            if (nums[low] == target)
                return low;
            if (nums[high] == target)
                return high;

            if (nums[mid] > nums[low]) {
                if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    if (nums[low] < target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            } else {
                if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    if (target > nums[high]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        return -1;
    }
}
