import java.util.*;

public class LC94_inorderTraversal {
    //递归方法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            if (node.left != null)
                inorderTraversal(node.left, res);
            res.add(node.val);
            if (node.right != null)
                inorderTraversal(node.right, res);
        }
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
