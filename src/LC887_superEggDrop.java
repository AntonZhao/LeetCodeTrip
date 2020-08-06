import java.util.HashMap;
import java.util.Map;

public class LC887_superEggDrop {
    public int superEggDrop(int K, int N) {
        // K个蛋，N层
        // 如果只有一层，不管几个蛋都是一次试出来
        // 如果只有一个蛋，每个层数都需要试n次
        // dp方程为 DP[]
        return dp(K, N);
    }

    Map<Integer, Integer> memo = new HashMap<>();

    private int dp(int k, int n) {
        if (n == 0 || k == 0) {
            memo.put(n * 100 + k, 0);
        }
        if (!memo.containsKey(n * 100 + k)) {
            int ans = Integer.MAX_VALUE;
            if (k == 1) {
                ans = n;
            } else if (n == 1) {
                ans = 1;
            } else {
                int left = 1, right = n;
                while (left <= right) {
                    int mid = (left + right) / 2;

                    int broken = dp(k - 1, mid - 1);
                    int not_broken = dp(k, n - mid);

                    if (broken > not_broken) {
                        right = mid - 1;
                        ans = Math.min(ans, broken + 1);
                    } else {
                        left = mid + 1;
                        ans = Math.min(ans, not_broken + 1);
                    }
                }
            }
            memo.put(n * 100 + k, ans);
        }
        return memo.get(n * 100 + k);
    }

    public static void main(String[] args) {
        LC887_superEggDrop ll = new LC887_superEggDrop();
        System.out.println(ll.superEggDrop(2, 6));
    }
}
