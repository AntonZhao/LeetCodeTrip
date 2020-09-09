import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77_combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new LinkedList<>(), k, n, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> curr, int k, int n, int start) {
        for (int i = start; i <= n; i++) {
            curr.add(i);
            if (curr.size() == k) {
                res.add(new LinkedList<>(curr));
            } else {
                dfs(res, curr, k, n, i+1);
            }
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        LC77_combine l = new LC77_combine();
        System.out.println(l.combine(4, 2));
    }
}
