import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JZ34_pathSum {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        dfs(new LinkedList<>(), sum, root);
        return res;
    }

    public void dfs(LinkedList<Integer> curr, int target, TreeNode node) {
        if (node == null) return;

        curr.add(node.val);

        if (target == node.val && node.left == null && node.right == null) {
            res.add(new ArrayList<>(curr));
            curr.removeLast();
            return;
        } else {
            dfs(curr, target - node.val, node.left);
            dfs(curr, target - node.val, node.right);
        }

        curr.removeLast();
    }

    public static void main(String[] args) {
        JZ34_pathSum ll = new JZ34_pathSum();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<List<Integer>> lists = ll.pathSum(root, 3);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
