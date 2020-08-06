import java.util.HashMap;
import java.util.Map;

public class LC96_numTrees {
    /**
     * leetcode-96 不同的二叉搜索树【中等】
     * 动态规划
     * 假设根节点一个，左子树a个，右子树n-a个
     */
    public int numTrees_dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= i - 1; j++) {
                sum += dp[j] * dp[i - 1 - j];
            }
            dp[i] = sum;
        }

        return dp[n];
    }

    // 递归方法
    Map<Integer, Integer> memory = new HashMap<>();

    public int numTrees_recursion(int n) {
        return helper(1, n);
    }

    private int helper(int begin, int end) {
        // 空二叉树也是一棵搜索二叉树
        if (begin > end) return 1;
        if (memory.containsKey(end - begin)) return memory.get(end - begin);

        int sum = 0;
        for (int i = begin; i <= end; i++) {
            int left_size = helper(begin, i - 1);
            int right_size = helper(i + 1, end);
            sum += left_size * right_size;
        }
        memory.put(end - begin, sum);

        return sum;
    }
}
