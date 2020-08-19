public class LC115_numDistinct {
    /**
     * 二维动态规划 但是效率并不高
     * <p>
     * 执行用时 10 ms, 在所有 Java 提交中击败了 32.21% 的用户
     * <p>
     * dp[i][j] = dp[i][j - 1]  + s == t ? dp[i - 1][j - 1] : 0
     * <p>
     * *  b  a  b  g  b  a  g
     * *  1  1  1  1  1  1  1  1
     * b  0  1  1  2  2  3  3  3
     * a  0  0  1  1  1  1  4  4
     * g  0  0  0  0  1  1  1  5
     */
    public int numDistinct_2d(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) dp[0][i] = 1;

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                dp[i][j] += t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : 0;
            }
        }
        return dp[t.length()][s.length()];
    }

    /**
     * 显然上面的二维可以优化成一维
     * <p>
     * 执行用时：8 ms, 在所有 Java 提交中击败了 77.40% 的用户
     */
    public int numDistinct_1d(String s, String t) {
        int[] dp = new int[s.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) dp[i] = 1;

        int prev = 1;
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                int temp = dp[j];
                if (j == 0) {
                    dp[j] = 0;
                } else {
                    if (t.charAt(i) == s.charAt(j - 1)) {
                        dp[j] = dp[j - 1] + prev;
                    } else {
                        dp[j] = dp[j - 1];
                    }
                }
                prev = temp;
            }
        }

        return dp[s.length()];
    }

    /**
     * 列主序 倒序计算 就不用保存临时值pre了
     * 可以按上图二维矩阵的顺序模仿一下 这个是11ms
     *
     * 不想看这个了 = =
     */
    public int numDistinct3(String s, String t) {
        // dp[0]表示空串
        int[] dp = new int[t.length() + 1];
        // dp[0]永远是1，因为不管S多长，都只能找到一个空串，与T相等
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[j + 1] += dp[j];
                }
            }

            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return dp[t.length()];
    }


    public static void main(String[] args) {
        LC115_numDistinct ll = new LC115_numDistinct();

        String s = "rabbbit";
        String t = "rabbit";
//        String s = "babgbag";
//        String t = "bag";
//        System.out.println(ll.numDistinct_2d(s, t));
        System.out.println(ll.numDistinct3(s, t));
    }
}
