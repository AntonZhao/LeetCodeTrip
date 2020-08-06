public class LC5_longestPalindrome {
    /**
     * 动态规划
     */
    public String longestPalindrome_dp(String s) {
        if (s.length() < 2) return s;
        int maxLen = 1, start = 0;
        int len = s.length();
        // dp矩阵，左边是left，右边是right，代表是这个区间是否是回文串
        boolean[][] dp = new boolean[len][len];

        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right)) {
                    // 如果相等，看看是否是最基本的回文串，即长度为3或者长度为1
                    // 若不是，则看看里面的是不是
                    if (right - left <= 2) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                } else {
                    dp[left][right] = false;
                }
                // 如果是回文串，看看能不能更新最大的长度
                if (dp[left][right]) {
                    int currLen = right - left + 1;
                    if (currLen > maxLen) {
                        maxLen = currLen;
                        start = left;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * 扩展中心
     */
    private int left, maxLen;

    public String longestPalindrome(String s) {
        if (s.equals("") || s.length() < 2)
            return s;
        maxLen = 0;
        left = 0;
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            extendPalidrome(s, i, i);
            extendPalidrome(s, i, i + 1);
        }
        return s.substring(left, left + maxLen);
    }

    private void extendPalidrome(String s, int l, int h) {
        while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
            l--;
            h++;
        }

        if (maxLen < h - l + 1) {
            maxLen = h - l + 1;
            left = l + 1;
        }
    }

    /**
     * 方法：最长公共子串
     * 原字符串和其反转后的最长公共子串
     */
    public static String longestPalindrome_1(String s) {
        if (s.equals(""))
            return "";
        String reS = new StringBuffer(s).reverse().toString();
        int[][] dp = new int[s.length()][s.length()];
        int maxLen = 0;
        int maxEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < reS.length(); j++) {
                if (s.charAt(i) == reS.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                if (dp[i][j] > maxLen) {
                    int beforeRev = s.length() - 1 - j;
                    if (beforeRev + dp[i][j] - 1 == i) {
                        maxLen = dp[i][j];
                        maxEnd = i;
                    }
                }
            }
        }

        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome_1("caba"));
        System.out.println(longestPalindrome_1("abacdfgdcaba"));
    }
}
