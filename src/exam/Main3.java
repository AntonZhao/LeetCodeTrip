package exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = 0;
        T = Integer.valueOf(scanner.nextLine().trim());
        for (int i = 0; i < T; i++) {
            int n = Integer.valueOf(scanner.nextLine().trim());
            String[] s = scanner.nextLine().trim().split(" ");

            int[] values = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, count = n;
            for (int j = 0; j < n; j++) {
                values[j] = Integer.valueOf(s[j]);
                sum += values[j];
                map.put(values[j], j);
            }

            int[] dp = new int[sum];
            for (int j = 0; j < count; j++) {
                for (int k = sum / 2; k >= values[j]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - values[j]] + values[j]);
                }
            }

            int x = sum - dp[sum / 2];
            int y = dp[sum / 2];

            int cha = sum / 2 - x;
            if (cha < 0) cha = -cha;
            int res = 0;
            for (int j = 0; j < values.length; j++) {
                if (map.containsKey(values[j] + cha * 2)) {
                    res = Math.min(res, values[j] + map.get(values[j] + cha));
                }
            }
            System.out.println(res);

        }

        scanner.close();
    }
}
