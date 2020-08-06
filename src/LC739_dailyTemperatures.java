import java.util.Stack;

public class LC739_dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
                // stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
