public class LC129_sumNumbers {
    private int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode node, int prev) {
        if (node == null) return;

        prev = prev * 10;

        if (node.left == null && node.right == null) {
            res += prev + node.val;
            return;
        }
        if (node.left != null) {
            dfs(node.left, prev + node.val);
        }
        if (node.right != null) {
            dfs(node.right, prev + node.val);
        }
    }
}
