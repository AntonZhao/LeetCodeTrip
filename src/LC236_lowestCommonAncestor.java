import com.sun.istack.internal.localization.NullLocalizable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC236_lowestCommonAncestor {
    /**
     * leetcode-236 二叉树的最近公共祖先 【中等】
     * 1.递归方法，简洁明了，就是不好写
     * 2.先用hashmap存储每个节点的父节点，然后用p一路往上找，记录下这个顺序；再用q一路往上找，用q找的路上如果碰到p遇到过的，那就是最近的了。
     *   因为二叉树只有从顶向下的信息，所以需要记录从下到上的信息
     * 优秀题解：
     */
    public TreeNode lowestCommonAncestor_recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p)
            return p;
        if (root == q)
            return q;

        TreeNode left = lowestCommonAncestor_recursion(root.left, p , q);
        TreeNode right = lowestCommonAncestor_recursion(root.right, p, q);
        // 在两边分别找到了p和q，所以root就是最近的祖先节点了
        if (left != null && right != null)
            return root;
        // 或者在当前的root的某一边，返回去再递归找
        if (left != null)
            return left;
        if (right != null)
            return right;

        return null;
    }
    /**
     * ----------------------------------迭代方法--------------------------------------------------
     */
    HashMap<Integer, TreeNode> parents = new HashMap<>();
    private void dfs(TreeNode root) {
        if (root.left != null) {
            parents.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 先去记录父节点的信息
        dfs(root);
        Set<TreeNode> visited = new HashSet<>();
        //开始找p到root的路径
        while (p != null) {
            visited.add(p);
            p = parents.get(p.val);
        }
        //找q的路径的同时看在p的路径中是否出现过
        while (q != null) {
            if (visited.contains(q))
                return q;
            q = parents.get(q.val);
        }
        return null;
    }


}
