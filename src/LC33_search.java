public class LC33_search {
    /**
     * 20200815 新鲜出炉
     * 我说按照两种不同情况分的类型，然后才去比对大小，更顺着思路
     */
    public int search_new(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;

            if (nums[mid] > nums[right]) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    if (nums[right] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    if (nums[right] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
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
