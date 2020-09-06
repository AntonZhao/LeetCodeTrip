package exam;

import java.util.HashMap;
import java.util.Map;

public class LC5494_countRoutes {
    /**
     * 1. 记忆化递归方法
     */
    long MOD = 1000000007;
    Map<String, Long> mem = new HashMap<>();

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int dfs = (int) (dfs(locations, start, finish, fuel));
        for (Map.Entry<String, Long> entry : mem.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return dfs;
    }

    private long dfs(int[] locations, int start, int finish, int fuel) {
        String key = start + "-" + finish + "-" + fuel;

        if (mem.containsKey(key))
            return mem.get(key);
        long count = 0;
        if (start == finish)
            count++;
        for (int i = 0; i < locations.length; i++) {
            int left = fuel - Math.abs(locations[i] - locations[start]);
            if (i != start && left >= 0) {
                count += dfs(locations, i, finish, left);
            }
        }
        count %= MOD;
        mem.put(key, count);
        return count;
    }

    /**
     * 2. DP
     */
    public int countRoutes_dp(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int mod = 1000000007;

        // dp[i][j]表示在第i个城市剩余j的汽油的方案数
        long[][] dp = new long[n][fuel + 1];
        // 初始化起始位置即可
        dp[start][fuel] = 1;

        for (int k = fuel; k >= 0; k--) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        // 在当前剩余油量 k 下，j 城市可以到达 i 城市，
                        // 那么就更新 j 城市在（当前油量 k 减去 (j城市到达i城市耗油)） 的路径数目，
                        // 更新方式就是加上 i 的路径数目
                        int differ = Math.abs(locations[i] - locations[j]);
                        if (k - differ >= 0)
                            dp[j][k - differ] = (dp[j][k - differ] + dp[i][k]) % mod;
                    }
                }
            }
        }

        long res = 0;
        // 把不同剩余油量的终点位置方案数目加起来就是最后的答案
        for (int i = 0; i <= fuel; i++) {
            res = (res + dp[finish][i]) % mod;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        LC5494_countRoutes ll = new LC5494_countRoutes();
        System.out.println(ll.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5));
        System.out.println(ll.countRoutes_dp(new int[]{2, 3, 6, 8, 4}, 1, 3, 5));
    }
}
