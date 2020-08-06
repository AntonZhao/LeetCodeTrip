import java.util.ArrayList;
import java.util.List;

public class LC113_pathSum {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(sum, root, path);
        return res;
    }

    private void dfs(int sum, TreeNode node, List<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        } else {
            dfs(sum - node.val, node.left, path);
            dfs(sum - node.val, node.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = a;
        for(int c : b) {
            System.out.println(c);
        }
    }
}
