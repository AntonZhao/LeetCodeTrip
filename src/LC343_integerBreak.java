import java.util.*;

public class LC343_integerBreak {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        if (n == 5) return 6;


        int prev = 1;
        int remainder = n % 3;
        for (int i = 0; i < n / 3; i++) {
            prev *= 3;
        }
        if (remainder == 0) return prev;
        if (remainder == 1) {
            return prev + prev / 3;
        } else {
            return prev * 2;
        }
    }

    public int integerBreak_dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int size = 5;
        Map<String, String> map = new LinkedHashMap<String, String>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > size;
            }
        };

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        System.out.println(map.toString());

        map.put("6", "6");
        System.out.println(map.toString());
        map.get("3");
        System.out.println(map.toString());
        map.put("7", "7");
        System.out.println(map.toString());
        map.get("5");
        System.out.println(map.toString());

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

    }
}
