import java.util.HashMap;
import java.util.Map;

public class LC136_singleNumber {
    /**
     * leetcode-136 只出现一次的数字 【简单】
     * 最好的方法是利用位运算，异或的性质，最后就是只出现一次的数字
     * 优秀题解：
     */

    public int singleNumber_best(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1 ^ 2);
    }
}
