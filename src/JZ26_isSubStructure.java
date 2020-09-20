import java.util.LinkedList;
import java.util.Queue;

public class JZ26_isSubStructure {

    /**
     * 递归实现
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B== null)
            return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }

    /**
     * 迭代实现
     */
    public boolean isSubStructure_queue (TreeNode A, TreeNode B) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (isSub(node, B))
                    return true;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return false;
    }

    boolean isSub(TreeNode curr, TreeNode son) {
        if (curr == null && son == null)
            return true;
        if (curr == null || son == null)
            return false;
        if (curr.val != son.val)
            return false;

        boolean res = true;
        if (son.left != null)
            res &= isSub(curr.left, son.left);
        if (son.right != null)
            res &= isSub(curr.right, son.right);
        return res;
    }
}
