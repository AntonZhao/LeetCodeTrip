import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40_combinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, target, new LinkedList<>(), candidates, res);
        return res;
    }

    private void dfs(int depth, int target, LinkedList<Integer> path, int[] candidates, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }
        for (int i = depth; i < candidates.length; i++) {
            if (i > depth && candidates[i] == candidates[depth]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(i + 1, target - candidates[i], path, candidates, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        LC40_combinationSum2 ll = new LC40_combinationSum2();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        ll.combinationSum2(nums, 8);
    }
}
