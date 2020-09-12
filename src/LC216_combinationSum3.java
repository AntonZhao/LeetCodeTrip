import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216_combinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(k, new LinkedList<Integer>(), n, nums, res);
        return res;
    }

    private void dfs(int depth, LinkedList<Integer> curr, int target, int[] nums, List<List<Integer>> res) {
        if (depth == 0 && target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (depth == 0 || target <= 0) {
            return;
        }
        int start = curr.isEmpty() ? 0 : curr.getLast();
        for (int i = start; i < 9; i++) {
            curr.add(nums[i]);
            dfs(depth - 1, curr, target - nums[i], nums, res);
            curr.removeLast();
        }

    }
}
