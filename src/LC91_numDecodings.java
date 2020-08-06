public class LC91_numDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            int cur = s.charAt(i - 1) - '0';
            int withPrev = (s.charAt(i - 2) - '0') * 10 + cur;
            if (cur != 0) {
                dp[i] += dp[i - 1];
            }
            if (withPrev >= 10 && withPrev <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[len];
    }
}
