import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class        LC47_permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(0, path, used, res, nums);

        return res;
    }

    private void dfs(int depth, List<Integer> path, boolean[] used, List<List<Integer>> res, int[] nums) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
                    continue;

                used[i] = true;
                path.add(nums[i]);

                dfs(depth + 1, path, used, res, nums);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LC47_permuteUnique ll = new LC47_permuteUnique();
        int[] nums = {1, 1, 3};
        System.out.println(ll.permuteUnique(nums));
    }
}
