import java.util.*;

public class LC32_longestValidParentheses {
    // DP
    public int longestValidParentheses_dp(String s) {
        // dp[i]表示以i结尾得到的最大长度
        int[] dp = new int[s.length()];
        // 记录尚未匹配的左括号长度
        int leftCount = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左括号结尾时候并不需要更新dp数组，因为合法子串不会以左括号结尾，所以肯定是0
                // 匹配到左括号，更新leftCount
                leftCount++;
            } else if (leftCount > 0) { // 匹配到右括号，需要左括号数量大于0才合法，否则是空谈
                dp[i] = dp[i - 1] + 2; // 当前右括号和自己「专属」的左括号算作2位,但是i-1不一定是左括号
                leftCount--; // 匹配到一个右括号，左括号减一
                dp[i] += i - dp[i] >= 0 ? dp[i - dp[i]] : 0; // 找到属于自己真正左括号前面，看有没有也是合法的

                result = Math.max(result, dp[i]);
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
        LC32_longestValidParentheses ll = new LC32_longestValidParentheses();
        String s = ")((()))()";
        System.out.println(ll.longestValidParentheses_stack(s));

    }
}
