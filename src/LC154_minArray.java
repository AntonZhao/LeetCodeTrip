public class LC154_minArray {
    public int minArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        LC154_minArray ll = new LC154_minArray();
        int[] nums = {2, 2, 2, 0, 1};
        System.out.println(ll.minArray(nums));
    }
}
