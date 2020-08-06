public class search33 {
    /**
     * 题目要求O(logN) 的时间复杂度，基本可以断定本题是需要使用二分查找，怎么分是关键。
     * 由于题目说数字了无重复，举个例子：
     * 1 2 3 4 5 6 7 可以大致分为两类，
     * 第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
     * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
     * 第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
     * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。
     */
    public static int search(int[] nums, int target) {
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
                if (target > nums[mid])
                    low = mid + 1;
                else {
                    if (target > nums[low])
                        high = mid - 1;
                    else
                        low = mid + 1;
                }
            } else {
                if (target > nums[mid])
                    if (target < nums[high])
                        low = mid + 1;
                    else
                        high = mid - 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }
}
