public class LC10_isMatch {
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0)
            return (s == null || s.length() == 0);

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        /**
         *  这里是dp的第一行，求的是pattern能否和空串匹配，毫无疑问dp[0][0]是true
         *  从pattern的第二个字符开始找，因为第一个不可能是 *
         *  如果当前位置是「*」，说明当前位置及之前的可以表示为空，
         *  若想pattern(0, j - 1)都可以匹配为空，还需要查看「j - 2」位是否为true！
         */
        for (int j = 2; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    /**
                     * 上面的「.」不难理解。
                     * 下面的是pattern当前值为「*」的情况
                     *      1. acts as an empty set，所以结果是dp[i][j - 2]
                     *      2. 如果可以匹配，要么值相同，要么pattern前一位是「.」，至少匹配一位，所以是 dp[i - 1][j]
                     */
                    dp[i][j] = dp[i][j - 2] ||
                            ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        LC10_isMatch ll = new LC10_isMatch();
        System.out.println(ll.isMatch(s, p));
    }
}
