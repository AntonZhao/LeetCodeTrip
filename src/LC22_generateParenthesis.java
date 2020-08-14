import java.util.ArrayList;
import java.util.List;

public class LC22_generateParenthesis {
    /**
     * leetcode-22 括号生成【中等】
     * 思路：递归的方式，先生成左，再生成右，可以连续生成左，右只能左有了才能生成。
     * 优秀题解：
     */
    List<String> res;
    int size;

    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        this.size = n;
        generate(0, 0, "");
        return res;
    }

    void generate(int left, int right, String curr) {
        if (left == size && right == size) {
            res.add(new String(curr));
        }

        if (left < size) {
            generate(left + 1, right, curr + "(");
        }
        if (left > right) {
            generate(left, right + 1, curr + ")");
        }
    }

    public static void main(String[] args) {
        LC22_generateParenthesis l = new LC22_generateParenthesis();
        System.out.println(l.generateParenthesis(3));
    }
}
