import java.util.Stack;

public class validateStackSequences946 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int size = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < size; pushIndex++) {
            stack.push(pushed[pushIndex]);
            while (popIndex < size && !stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
