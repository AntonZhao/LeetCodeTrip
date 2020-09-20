import java.util.ArrayList;
import java.util.Stack;

public class JZ31_validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int p_pop = 0, p_push = 0;
        while (p_pop < popped.length) {
            if (!stack.isEmpty() && stack.peek() == popped[p_pop]) {
                stack.pop();
                p_pop++;
            } else {
                while (p_push <= pushed.length) {
                    if (p_push == pushed.length)
                        return false;
                    stack.push(pushed[p_push++]);
                    if (pushed[p_push - 1] == popped[p_pop])
                        break;
                }
            }
        }
        return true;
    }
}
