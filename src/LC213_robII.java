import java.util.ArrayList;
import java.util.List;

public class LC213_robII {
    /**
     * 首先，首尾房间不能同时被抢，那么只可能有三种不同情况：
     * 要么都不被抢；要么第一间房子被抢最后一间不抢；要么最后一间房子被抢第一间不抢。
     * 只要比较情况二和情况三就行了，
     * 因为这两种情况对于房子的选择余地比情况一大呀，房子里的钱数都是非负数，所以选择余地大，最优决策结果肯定不会小。
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n - 2),
                robRange(nums, 1, n - 1));
    }

    public int robRange(int[] nums, int start, int end) {

        int currMax = 0, preMax = 0;
        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(nums[i] + preMax, currMax);
            preMax = temp;
        }
        return currMax;
    }

    public static List<String> ppp(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(0, "", chars, res);
        return res;
    }

    private static void dfs(int depth, String curr, char[] chars, List<String> res) {
        if (depth == chars.length) {
            res.add(new String(curr));
            System.out.println(curr);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (curr.indexOf(chars[i]) != -1) continue;
            dfs(depth + 1, curr + chars[i], chars, res);
        }
    }

    public static void main(String[] args) {
        ppp("ABCD");
    }
}
