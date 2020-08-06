import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, new ArrayList<>(), candidates, res);
        return res;
    }

    private void backtrack(int depth, int target, ArrayList<Integer> path, int[] candidates, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        for (int i = depth; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(i, target - candidates[i], path, candidates, res);
            // not i + 1 because we can reuse same elements
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC39_combinationSum ll = new LC39_combinationSum();

        int[] cc = {2, 3, 6, 7};
        ll.combinationSum(cc, 7);
    }
}
