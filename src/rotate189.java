public class rotate189 {
    //暴力解法
    public static void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int cur = nums[nums.length - 1];
            for (int j = nums.length - 1 - 1; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = cur;
        }
    }
    //使用环状替换
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
                printNums(nums);
            } while (start != current);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
//        rotate1(nums, 0);
        rotate2(nums, 2);
        printNums(nums);
    }

    private static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


}
