import java.util.*;

public class LC39_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, new LinkedList<>(), target, candidates, res);
        return res;
    }

    private void dfs(int depth, LinkedList<Integer> curr, int target, int[] candidates, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (0 == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = depth; i < candidates.length; i++) {
            curr.add(candidates[i]);
            dfs(i, curr, target - candidates[i], candidates, res);
            curr.removeLast();
        }

    }


    public static void main(String[] args) {
        LC39_combinationSum ll = new LC39_combinationSum();

        int[] cc = {2, 3, 6, 7};
        List<List<Integer>> lists = ll.combinationSum(cc, 7);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
