import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199_rightSideView {
    /**
     * leetcode-199 二叉树的右视图【中等】
     * 1.层序遍历，每层的最右
     * 2.bfs size--
     * 优秀题解：
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (size == 0) {
                    res.add(cur.val);
                }
            }
        }
        return res;
    }
}
