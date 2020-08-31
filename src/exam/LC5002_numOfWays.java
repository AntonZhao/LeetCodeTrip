package exam;

import java.math.BigInteger;
import java.util.Arrays;

public class LC5002_numOfWays {

    final int MOD = 1000000007;

    public int numOfWays(int[] nums) {
        long count = getCount(nums);
        if (count == 0)
            return MOD - 1;
        return (int) (count - 1);
    }

    private long getCount(int[] nums) {
        if (nums.length <= 1) return 1;

        int pivot = nums[0];
        int[] smaller = Arrays.stream(nums).filter(item -> item < pivot).toArray();
        int[] bigger = Arrays.stream(nums).filter(item -> item > pivot).toArray();

        long n = getCombination(nums.length - 1, Math.min(smaller.length, bigger.length));

        long result = (getCount(smaller) * getCount(bigger) % MOD) * n % MOD;

        return result;
    }

    private long getCombination(int great, int small) {
        int a = 1;
        int b = great;
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 0; i < small; i++) {
            res = res.multiply(BigInteger.valueOf(b)).divide(BigInteger.valueOf(a));
            b--;
            a++;
        }
        res = res.remainder(BigInteger.valueOf(1000000007));
        return res.longValue();
    }


    public static void main(String[] args) {
        LC5002_numOfWays ll = new LC5002_numOfWays();

        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(ll.numOfWays(nums));
    }
}
