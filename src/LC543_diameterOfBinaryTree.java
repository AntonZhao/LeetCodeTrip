public class LC543_diameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;
    }
}
