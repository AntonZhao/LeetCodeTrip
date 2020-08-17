public class LC124_maxPathSum {

    private int max;

    public int maxPathSum(TreeNode root) {
        /**
         * 对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
         *    1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
         *    2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
         **/
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, dfs(node.right));

        max = Math.max(max, node.val + left + right);  // 判断在该节点包含左右子树的路径和是否大于当前最大路径和

        return Math.max(left, +right) + node.val;
    }
}
