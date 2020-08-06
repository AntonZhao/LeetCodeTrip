import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, new ArrayList<>(), candidates, res);
        return res;
    }

    private void backtrack(int depth, int target, ArrayList<Integer> path, int[] candidates, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = depth; i < candidates.length; i++) {
            if (i > depth && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], path, candidates, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC40_combinationSum2 ll = new LC40_combinationSum2();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        ll.combinationSum2(nums, 8);
    }
}
