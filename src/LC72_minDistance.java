public class LC72_minDistance {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int len1 = w1.length, len2 = w2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    if (w1[i - 1] == w2[j - 1]) {
                        min = Math.min(min, dp[i - 1][j - 1] - 1);
                        dp[i][j] = 1 + min;
                    } else {
                        min = Math.min(min, dp[i - 1][j - 1]);
                        dp[i][j] = 1 + min;
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LC72_minDistance ll = new LC72_minDistance();
        String w1 = "zoologicoarchaeologist";
        String w2 = "zoogeologist";
        System.out.println(ll.minDistance(w1, w2));
    }
}
