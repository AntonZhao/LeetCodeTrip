import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class LC150_evalRPN {
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int c = a / b;
                stack.push(c);
            } else if (tokens[i].equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                int c = a * b;
                stack.push(c);
            } else if (tokens[i].equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                int c = a + b;
                stack.push(c);
            } else if (tokens[i].equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                int c = a - b;
                stack.push(c);
            } else {
                Integer num = Integer.valueOf(tokens[i]);
                stack.push(num);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] s = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

//        System.out.println(evalRPN(s));
        System.out.println(-1 % 4);
        int[] a = new int[3];
        a[-1] = 1;
        a[0] = 2;
        a[1] = 3;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

}
