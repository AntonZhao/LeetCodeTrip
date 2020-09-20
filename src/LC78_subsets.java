import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        dfs(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> curr, int index) {
        // terminator
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        //process
        dfs(res, nums, curr, index + 1); // 当前index的数字不被选取

        curr.add(nums[index]); //选取当前数字
        dfs(res, nums, curr, index + 1);

        // reverse state
        curr.remove(curr.size() - 1);
    }


    public static void main(String[] args) {
        LC78_subsets ll = new LC78_subsets();
        int[] nums = {1, 2, 3};
        System.out.println(ll.subsets(nums));
        LinkedList<Integer> list = new LinkedList<>();
    }
}
