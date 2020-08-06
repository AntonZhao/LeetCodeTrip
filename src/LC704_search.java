public class LC704_search {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0, right = nums.length - 1;

        while (left <= right) {
//            int mid = left + ((right - left) >> 1);
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC704_search ll = new LC704_search();
        int[] nn = {-1, 0, 3, 5, 9, 12};
        System.out.println(ll.search(nn, 9));
    }
}
