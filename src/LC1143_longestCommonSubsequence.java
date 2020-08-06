public class LC1143_longestCommonSubsequence {
    // space complexity m
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == "" || text2 == "")
            return 0;
        int[] dp = new int[text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i++) {
            int prev = 0;
            for (int j = 1; j < text2.length() + 1; j++) {
                int temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 这个时候需要旧的dp[i - 1][j - 1]，所以保存下
                    // 因为左边如果被更新，相当于dp[i - 1][j - 1]也被更新，所以需要保存旧的
                    dp[j] = prev + 1;
                } else {
                    // 这个时候需要左边的值是新的，新的dp[j - 1],就是二维中左边的值，也就是left变量
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }

        return dp[text2.length()];
    }

    // space complexity n*m
    public static int longestCommonSubsequence_2(String text1, String text2) {
        if (text1 == "" || text2 == "")
            return 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abcde", "ace"));
        String s1 = "xybyrgzc";
        String s2 = "bgncrcbih";
        System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(longestCommonSubsequence_2(s1, s2));


    }
}
