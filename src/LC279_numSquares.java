public class LC279_numSquares {
    /**
     * leetcode-279 完全平方数【中等】
     * 思路1：暴力递归会有很多重叠子问题重复计算，所以加一个记忆化步骤，使得不再重复计算。自顶向下，记忆化搜索
     * 思路2：根据上面的方法写出DP？
     * 思路3：数学法拉格朗日四平方定理 n=(4^k)*(8m+7) 如果符合是四个数字
     * 优秀题解：https://leetcode-cn.com/problems/perfect-squares/solution/bu-zhi-shi-da-an-er-shi-dong-tai-gui-hua-lei-ti-de/
     */
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        return numSquares(n, memo);
    }

    private int numSquares(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];
        // 当前数字如果是平方
        int val = (int) Math.sqrt(n);
        if (val * val == n)
            return memo[n] = 1;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            res = Math.min(res, 1 + numSquares(n - i * i, memo));
        }
        return memo[n] = res;
    }

    /**
     * DP方法
     */
    public int numSquares_dp(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                memo[i] = Math.min(memo[i], 1 + memo[i - j * j]);
            }
        }
        return memo[n];
    }

    /**
     * 吊炸天的数学方法
     */
    private boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public int numSquares_math(int n) {
        // four-square and three-square theorems.
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        if (this.isSquare(n))
            return 1;
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i))
                return 2;
        }
        // bottom case of three-square theorem.
        return 3;
    }

    public static void main(String[] args) {
        LC279_numSquares ll = new LC279_numSquares();
        System.out.println(ll.numSquares_dp(12));
    }
}
