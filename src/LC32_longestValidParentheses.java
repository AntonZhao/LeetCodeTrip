import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

public class LC32_longestValidParentheses {
    // DP
    public int longestValidParentheses_dp(String s) {
        int[] dp = new int[s.length()];
        int leftCount = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i] >= 0) ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }

        return result;
    }

    // 用栈
    public int longestValidParentheses_stack(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "           ";
        System.out.println(s.trim().length());
        Set<Character> set = new HashSet<>();
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (char c : s.toCharArray()) {
            treeMap.put(c, treeMap.getOrDefault(c, 0) + 1);
        }

        s = "abc";
        System.out.println(Integer.valueOf(s));
    }
}
