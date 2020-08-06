public class moveZeroes283 {
    public static void moveZeroes(int[] nums) {
        if (nums.length < 2)
            return;
        int pZero = 0;
        int pNotZero = 0;
        while (pNotZero != nums.length && pZero < nums.length) {
            if (nums[pZero] != 0) {
                pZero++;
                continue;
            }
            if (nums[pNotZero] == 0) {
                pNotZero++;
                continue;
            }
            if (pZero > pNotZero)
                pNotZero++;
            else
                swap(nums, pZero, pNotZero);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] ns = {0, 1, 0, 3, 12};
//        int[] ns = {1, 1, 1, 3, 12};
//        int[] ns = {0, 0, 0, 0, 0};
        int[] ns = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(ns);
        for (int i = 0; i < ns.length; i++) {
            System.out.print(ns[i] + " ");
        }
    }
}
