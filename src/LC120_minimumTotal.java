import java.util.ArrayList;
import java.util.List;

public class LC120_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (List<Integer> row : triangle) {
            if (row.size() == 1) {
                dp[0] = row.get(0);
                continue;
            }
            int prev = dp[0];
            for (int i = 0; i < row.size(); i++) {
                if (i == 0) {
                    dp[0] = row.get(i) + dp[0];
                } else if (i == row.size() - 1) {
                    dp[i] = row.get(i) + prev;
                } else {
                    int temp = dp[i];
                    dp[i] = row.get(i) + Math.min(dp[i], prev);
                    prev = temp;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp) {
            res = Math.min(i, res);
        }
        return res;

    }
}
