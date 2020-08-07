import java.util.Stack;


public class LC32_longestValidParentheses_old {

    /**
     * 1、先把 -1 放入栈内。（至于为什么？看到后面你就知道了）
     * 2、、对于遇到的每个 '(' ，我们将它的下标放入栈中。
     * 3、对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与当前栈的peek下标作差，得出当前有效括号字符串的长度。
     */
    public static int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = max > i - stack.peek() ? max : i - stack.peek();
                }
            }
        }
        return max;
    }

    /**
     * 进一步优化空间复杂度
     */
    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public int longestValidParentheses_timeOut(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
//                System.out.println(s.substring(i, j));
                if (isValid(s.substring(i, j)))
                    max = max > j - i ? max : j - i;
            }
        }
        return max;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
    }
}
