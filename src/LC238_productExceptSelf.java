public class LC238_productExceptSelf {
    //TC:O(n) SC:O(n)
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l_product = new int[len];
        int[] r_product = new int[len];
        int[] res = new int[len];

        l_product[0] = 1;
        r_product[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            l_product[i] = nums[i - 1] * l_product[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            r_product[i] = nums[i + 1] * r_product[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = l_product[i] * r_product[i];
        }

        return res;
    }

    //对上面的方法进一步优化，SC:O(1)
    public int[] productExceptSelf_2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;

        for (int i = 1; i < len; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int R = 1;
        for (int i = len - 2; i >= 0; i--) {
            res[i] = nums[i] * R;
            R *= nums[i];
        }
        return res;
    }
}
