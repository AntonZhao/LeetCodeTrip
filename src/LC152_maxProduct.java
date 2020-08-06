public class LC152_maxProduct {
    /**
     * leetcode-152 乘积最大的子数组【中等】
     * 0518是最新的代码，不用考虑正负号，
     * 每次循环无非就是考虑{当前数字, 当前数字 × 上个最大, 当前数字 × 上个最小}
     * 从这三个里面找到最大的和最小的更新max min即可
     * 优秀题解：
     */

    public int maxProduct_0518(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 1, currMin = 1;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = nums[i] * currMax;
            int c = nums[i] * currMin;

            currMax = Math.max(Math.max(a, b), c);
            currMin = Math.min(Math.min(a, b), c);

            max = Math.max(max, currMax);
        }

        return max;
    }

    public static int maxProduct(int[] nums) {
        /**
         * imax表示以当前节点为终结节点的最大连续子序列乘积
         * imin表示以当前节点为终结节点的最小连续子序列乘积
         *
         * 1. 遍历数组时计算当前最大值，不断更新
         * 2. 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
         * 3. 由于存在负数，那么会导致最大的变最小的，最小的变最大的。
         *    因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
         * 4. 当负数出现时则imax与imin进行交换再进行下一步计算,交换是因为负数让正数变小，让负数变大
         * 时间复杂度：O(n)
         */
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
            System.out.println(imax + " " + imin + " " + max);
        }
        return max;
    }

    public static int maxProduct_2(int[] nums) {
        int positive = nums[0];
        int negative = nums[0];
        int res = nums[0];
        /**
         *  如果当前数字大于0, positive选个更大的，negative就乘以当前数字
         *  如果当前数字小于0，
         *  positive和（negative乘当前数字）比较出一个更大的，
         *  negative 和（positive 乘 当前数字）选个更小的
         */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                positive = Math.max(nums[i], positive * nums[i]);
                negative = negative * nums[i];
            } else {
                int temp = positive;
                positive = Math.max(positive, negative * nums[i]);
                negative = Math.min(negative, temp * nums[i]);
            }
            res = Math.max(res, positive);
            res = Math.max(res, negative);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, -2, -9, -6};
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
