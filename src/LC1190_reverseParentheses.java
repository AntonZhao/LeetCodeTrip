import java.util.Stack;

public class LC1190_reverseParentheses {
    /**
     * leetcode-1190 反转每对括号间的子串【中等】
     * 思路：这道题可以看自己的题解
     * 优秀题解：
     */
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(i);
            } else if (chs[i] == ')') {
                reverse(chs, stack.pop() + 1, i - 1);
            }
        }
        for (char ch : chs) {
            if (ch != '(' && ch != ')') {
                res.append(ch);
            }
        }
        return res.toString();
    }

    private void reverse(char[] chs, int start, int end) {
        while (end > start) {
            char temp = chs[end];
            chs[end] = chs[start];
            chs[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LC1190_reverseParentheses ll = new LC1190_reverseParentheses();
        System.out.println(ll.reverseParentheses("(ed(et(oc))el)"));
    }

    /**
     * 牛逼的虫洞法
     * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/discuss/383670/JavaC%2B%2BPython-Why-not-O(N)
     */
    public String reverseParentheses_nb(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[n];

        //先去找匹配的括号
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder res = new StringBuilder();
        // i是当前位置 | d是方向,1就是向右穿
        for (int i = 0, d = 1; i < n; i+=d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                // 如果碰到括号，那么去他对应的括号，并且将方向置反
                i = pair[i];
                d = -d;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
