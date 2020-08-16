public class LC81_search {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] == target) return true;
            if (nums[right] == target) return true;

            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

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

        return false;
    }

    public static void main(String[] args) {
        LC81_search ll = new LC81_search();

//        int[] nums = {2, 5, 6, 0, 0, 1, 2};
//        int target = 3;

        int[] nums = {1, 3};
        int target = 2;
        System.out.println(ll.search(nums, target));
    }
}
