import java.util.ArrayList;
import java.util.List;

public class LC257_binaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        dfs(res, root, "");

        return res;
    }

    private void dfs(List<String> res, TreeNode node, String curr) {
        if (node.left == null && node.right == null) {
            res.add(new String(curr + node.val));
            return;
        }

        if (curr.equals("")) {
            curr = node.val + "->";
        } else {
            curr += node.val + "->";
        }

        if (node.left != null) {
            dfs(res, node.left, curr);
        }
        if (node.right != null) {
            dfs(res, node.right, curr);
        }
    }
}
