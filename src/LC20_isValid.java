import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC20_isValid {
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
        LC20_isValid solution = new LC20_isValid();
        System.out.println(solution.isValid("("));

        String curr = "";
        curr += "}";
        System.out.println(curr);

        List<String> res = new ArrayList<>();
        res.add(new String(curr));
    }
}
