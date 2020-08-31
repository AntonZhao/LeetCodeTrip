package exam;

public class LC5500_getMaxLen {

    public int getMaxLen(int[] nums) {
        int[] re_nums = new int[nums.length];
        for (int i = 0; i < re_nums.length; i++) {
            re_nums[i] = nums[nums.length - i - 1];
        }
        int i = getMaxLen_(nums);
        int j = getMaxLen_(re_nums);

        return Math.max(i, j);
    }

    public int getMaxLen_(int[] nums) {

        int[] lens = new int[nums.length];

        int prev_negtive = -1;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
//                System.out.println(i);
                lens[i] = i == 0 ? 1 : lens[i - 1] + 1;
                res = Math.max(res, lens[i]);
            } else if (nums[i] == 0) {
                lens[i] = 0;
                prev_negtive = -1;
            } else {
                lens[i] = 0;
                // 小于0
                if (prev_negtive != -1) {
                    nums[i] *= -1;
                    nums[prev_negtive] *= -1;
                    i = prev_negtive - 1;

                    prev_negtive = -1;
                } else {
                    prev_negtive = i;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC5500_getMaxLen ll = new LC5500_getMaxLen();
        int[] nums = new int[]{1, -2, -3, 4};
        nums = new int[]{1, -2, -3, -4};
        nums = new int[]{1, -2, -3, -4, -8, 0};
        nums = new int[]{1, -2, -3, -4, -8, 0, 9, 1, 1, 1, 1, 1, 1};
        nums = new int[]{-16, 0, -5, 2, 2, -13, 11, 8};
        nums = new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2};
        System.out.println(ll.getMaxLen(nums));
    }
}
