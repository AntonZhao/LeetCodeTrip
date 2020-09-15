import java.util.*;

public class LC94_inorderTraversal {
    //递归方法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        _inorder(root, res);
        return res;
    }

    void _inorder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        _inorder(node.left, res);
        res.add(node.val);
        _inorder(node.right, res);
    }

    //迭代访问，维护一个栈
    public List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}
