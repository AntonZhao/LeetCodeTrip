import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC491_findSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;

            set.add(nums[i]);

            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(nums[i]);
            dfs(res, nums, i, curr);
        }

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index, ArrayList<Integer> curr) {
        if (curr.size() >= 2)
            res.add(new ArrayList<>(curr));

        HashSet<Integer> set = new HashSet<>();

        for (int i = index + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;

            if (nums[i] >= curr.get(curr.size() - 1)) {
                set.add(nums[i]);
                curr.add(nums[i]);
                dfs(res, nums, i, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        LC491_findSubsequences ll = new LC491_findSubsequences();

        List<List<Integer>> lists = ll.findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(lists.size());

        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

}
