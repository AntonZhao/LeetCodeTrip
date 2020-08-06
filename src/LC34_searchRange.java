public class LC34_searchRange {
    /**
     * leetcode-34 在排序数组中查找元素的第一个和最后一个位置【中等】
     * 思路：两次二分查找
     * 最牛逼题解：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = left_bound(nums, target);
        res[1] = right_bound(nums, target);
        return res;

    }

    /**
     * 二分查找---寻找左侧边界
     */
    private int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; //都是闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 别返回，收缩左侧边界
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    /**
     * 二分查找---寻找右侧边界
     */
    private int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; //都是闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 别返回，收缩右侧边界
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    /**
     * 二分查找---普通
     */
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }


    public static void main(String[] args) {
        LC34_searchRange ll = new LC34_searchRange();
//        int[] nums = {1,3};
//        int[] nums = {1};
        int[] nums = {1, 4};
        int target = 4;

        int[] res = ll.searchRange(nums, target);
        System.out.println(res[0] + "  " + res[1]);
    }
}
