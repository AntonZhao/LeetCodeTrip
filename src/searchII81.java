import java.util.HashMap;

public class searchII81 {
    /**
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
     */
    public static boolean searchII(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[low] == nums[mid]){
                low++;
                continue;
            }

            if (nums[low] < nums[mid]){ //前半部分大
                if (nums[mid] > target && nums[low] <= target){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if (nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }


        return false;
    }
}
