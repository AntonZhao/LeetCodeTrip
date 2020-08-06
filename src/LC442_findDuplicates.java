import java.util.*;

public class LC442_findDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1)
                res.add(nums[i]);
        }
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> findDuplicates_3(int[] nums) {
        List<Integer> twice = new ArrayList<>();

        // number 4' status is tracked at index 3

        // pos -> neg means appearing once
        // neg -> pos means appearing twice

        for (int i = 0; i < nums.length; i++) {
            int realNumber = Math.abs(nums[i]);
            int index = realNumber - 1;

            nums[index] = -nums[index];
            if (nums[index] > 0) twice.add(realNumber);
        }

        return twice;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        findDuplicates(nums);

        int a = 200000;
        int b = 127;
        System.out.println("a = " + a + " b = " + b);
        a = a ^ b;
        System.out.println(a);
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + " b = " + b);
    }
}
