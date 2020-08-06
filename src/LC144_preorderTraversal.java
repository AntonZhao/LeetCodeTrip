import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            if (node.left != null)
                preorderTraversal(node.left, res);
            if (node.right != null)
                preorderTraversal(node.right, res);
        }
    }

    public List<Integer> preorderTraversal_stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            res.add(curr.val);

            if (curr.right != null)
                stack.push(curr.right);

            curr = curr.left;

            if (curr.left != null)
                stack.push(curr.left);
            if (curr == null && !stack.isEmpty())
                curr = stack.pop();
        }
        return res;
    }

    public List<Integer> pre_linkedList(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
