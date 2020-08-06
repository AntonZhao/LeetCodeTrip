import java.util.ArrayList;
import java.util.List;

public class LC70_minimumTotal {
    /**
     * f[i,j] = a[i,j] + min(f[i+1,j] , f[i+1,j+1])
     */
    public int minimumTotal_On(List<List<Integer>> triangle) {
        int n = triangle.size();

        List<Integer> dp = triangle.get(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> thisRow = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                dp.set(j, thisRow.get(j) + Math.min(dp.get(j), dp.get(j+1)));
            }
        }

        return dp.get(0);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];

        List<Integer> lastRow = triangle.get(n - 1);

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = lastRow.get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> thisRow = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = thisRow.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }

    // 递归
    int row;
    Integer[][] memo;

    public int minimumTotal_recursion(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return helper(0,0, triangle);
    }
    private int helper(int level, int c, List<List<Integer>> triangle){
        // System.out.println("helper: level="+ level+ " c=" + c);
        if (memo[level][c]!=null)
            return memo[level][c];
        if (level==row-1){
            return memo[level][c] = triangle.get(level).get(c);
        }
        int left = helper(level+1, c, triangle);
        int right = helper(level+1, c+1, triangle);
        return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
    }

    public static void main(String[] args) {
//        List<List<Integer>> ll = new ArrayList<>();
//        for (int i = 1; i <= 4; i++) {
//            List<Integer> l = new ArrayList<>();
//            for (int j = 0; j < i; j++) {
//                l.add(i + j);
//            }
//            ll.add(l);
//        }
//        minimumTotal(ll);
        int a = Math.min(2,3) + 4;
        System.out.println(a);
    }
}
