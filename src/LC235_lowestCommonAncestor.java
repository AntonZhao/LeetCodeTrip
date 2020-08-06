import java.util.LinkedList;
import java.util.Queue;

public class LC235_lowestCommonAncestor {
    /**
     * leetcode-235 二叉搜索树的最近公共祖先 【简单】
     * 根据二叉搜索树左小右大的性质，很容易找到LCA节点
     * 优秀题解：
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode bigNode = p.val > q.val ? p : q;
        TreeNode smallNode = p.val > q.val ? q : p;
        // 开始层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val >= smallNode.val && temp.val <= bigNode.val)
                return temp;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return root;
    }
}
