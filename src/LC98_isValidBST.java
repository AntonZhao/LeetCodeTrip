import java.util.Stack;

public class LC98_isValidBST {
    /**
     * leetcode-98 验证二叉树 【中等】
     * 考察二叉树的性质以及中序遍历
     * 优秀题解：
     */
    // 根据bst定义去递归
    public boolean isValidBST_define(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;

        return true;
    }

    // bst的中序遍历是递增的, 使用递归中序遍历
    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST(root.right);
    }

    // bst的中序遍历是递增的, 使用迭代中序遍历
    public boolean isValidBST_iteration(TreeNode root) {
        //中序遍历方法，因为bst的中序遍历是递增的
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while(root != null || !stack.isEmpty()) {
            //一直往左下找
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            // 把最左的取出来
            // 这个prev，顾名思义就是上一个节点
            // 因为是BST，上一个就应该比现在的小
            root = stack.pop();
            if (prev != null && prev.val >= root.val)
                return false;
            prev = root;
            root = root.right;
        }

        return true;
    }


}
