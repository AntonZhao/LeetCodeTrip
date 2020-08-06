public class LC392_isSubsequence {
    /**
     * LeetCode392. 判断子序列 动态规划解法(带图)
     *
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        // dp数组dp[i][j]表示字符串t以i位置开始第一次出现字符j的位置
        int[][] dp = new int[m + 1][26];
        // 初始化边界条件，dp[i][j] = m 表示t中不存在字符j
        for (int i = 0; i < 26; i++) {
            dp[m][i] = m;
        }
        // 从后往前递推初始化dp数组
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == 'a' + j)
                    dp[i][j] = i;
                else
                    dp[i][j] = dp[i + 1][j];

            }
        }

        // 开始遍历字符串s，生成dp数组后，才开始用字符串s，方便处理多个多个s
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (dp[add][s.charAt(i) - 'a'] == m)
                return false;
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }

        return true;
    }
}
