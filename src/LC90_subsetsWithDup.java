import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> curr, int[] nums, int depth) {
        res.add(new ArrayList<>(curr));

        for (int i = depth; i < nums.length; i++) {
            if (i > depth && nums[i] == nums[i - 1])
                continue;
            curr.add(nums[i]);
            dfs(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }


    public static void main(String[] args) {
        LC90_subsetsWithDup ll = new LC90_subsetsWithDup();
        int[] nums = {1, 1, 3};
        System.out.println(ll.subsetsWithDup(nums));
//        ll.subsetsWithDup(nums);
    }
}
