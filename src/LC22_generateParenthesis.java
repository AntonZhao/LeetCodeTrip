import java.util.ArrayList;
import java.util.List;

public class LC22_generateParenthesis {
    /**
     * leetcode-22 括号生成【中等】
     * 思路：递归的方式，先生成左，再生成右，可以连续生成左，右只能左有了才能生成。
     * 优秀题解：
     */
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        _generate(0, 0, n, "");
        return res;
    }

    private void _generate(int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        //process & drill down
        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            _generate(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        LC22_generateParenthesis l = new LC22_generateParenthesis();
        System.out.println(l.generateParenthesis(3));
    }
}
