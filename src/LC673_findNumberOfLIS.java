import java.util.Arrays;

public class LC673_findNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; // 在位置i的最长递增子序列长度
        int[] counts = new int[N]; // 在位置i的最长递增子序列长度的个数
        Arrays.fill(counts, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[j] >= lengths[i]) {

                    }
                }
            }
        }

        return 0;
    }
}
