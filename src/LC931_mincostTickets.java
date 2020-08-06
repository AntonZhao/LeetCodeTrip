import java.util.HashSet;
import java.util.Set;

public class LC931_mincostTickets {
    /**
     * leetcode-931 最低票价 【中等】
     * 该方法是从后向前迭代，你可能会想，是否可以从前向后迭代？
     * 我觉得应该不可以，因为票是向后有效的，从前面买的无法保证局部最优，所以很难想
     * 优秀题解：
     */
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31];
        // 把需要旅行的日期放进一个set里
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }
        // 只搜索旅行区间内的日期
        for (int i = maxDay; i >= minDay; i--) {
            // 如果这天是旅行日，需要进行决策
            if (travelDays.contains(i)) {
                dp[i] = minOf3(costs[0] + dp[i + 1], costs[1] + dp[i + 7], costs[2] + dp[i + 30]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[minDay];
    }

    private int minOf3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
