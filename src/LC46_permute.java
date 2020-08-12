import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return res;

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, used, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, boolean[] used, int depth, List<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, used, depth + 1, path, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(depth);
                path.remove(path.size());
            }
        }
    }


    public static void main(String[] args) {
        LC46_permute ll = new LC46_permute();
        int[] nums = {1, 2, 3};
        System.out.println(ll.permute(nums));
    }
}
