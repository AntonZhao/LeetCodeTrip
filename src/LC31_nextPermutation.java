import java.util.Arrays;

public class LC31_nextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                Arrays.sort(nums, i, nums.length);
                break;
            }
        }
    }

    public static void main(String[] args) {
        LC31_nextPermutation ll = new LC31_nextPermutation();
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums = {1,2,3,4,3,2,1};
        ll.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
