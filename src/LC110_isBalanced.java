public class LC110_isBalanced {

    /**
     * 自底向上
     */
    public boolean isBalance_(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode node) {
        if (node == null) return 0;

        int left = recur(node.left);
        if (left == -1) return -1;

        int right = recur(node.right);
        if (right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    /**
     * 自顶向下，暴力法，很多冗余计算
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        // 当前节点左右子树的深度之差小于2 且 左子树和右子树也都是平衡树
        return Math.abs(depth(root.left) - depth(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    // 获得当前节点的深度
    private int depth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
