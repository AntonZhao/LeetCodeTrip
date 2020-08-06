public class LC97_isInterleave {
    /**
     * dp[i][j] = (s2[0 ~ i-1] + s1[0 ~ j-1]) == s3[0 ~ i+j-1]
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int s1_length = s1.length();
        int s2_length = s2.length();
        boolean[][] dp = new boolean[s2_length + 1][s1_length + 1];

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();

        dp[0][0] = true;
        for (int i = 1; i <= s1_length; i++) {
            dp[0][i] = dp[0][i - 1] && chs1[i - 1] == chs3[i - 1];
        }
        for (int i = 1; i <= s2_length; i++) {
            dp[i][0] = dp[i - 1][0] && chs2[i - 1] == chs3[i - 1];
        }

        for (int i = 1; i <= s2_length; i++) {
            for (int j = 1; j <= s1_length; j++) {
                dp[i][j] = (dp[i - 1][j] && (chs2[i - 1] == chs3[i + j - 1]))
                        || (dp[i][j - 1] && (chs1[j - 1] == chs3[i + j - 1]));
            }
        }

        return dp[s2_length][s1_length];
    }
}
