import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77_combine {
    private List<List<Integer>> res;
    private int k;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        this.res = new LinkedList<>();
        this.k = k;
        this.n = n;
        backtrack(1, new LinkedList<>());
        return res;
    }

    private void backtrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
            System.out.println(curr);
            return;
        }
        for (int i = first; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        LC77_combine l = new LC77_combine();
        System.out.println(l.combine(4, 2));
    }
}
