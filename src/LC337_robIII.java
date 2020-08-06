import java.util.HashMap;
import java.util.Map;

public class LC337_robIII {
    /**
     * 整体的思路完全没变，还是做抢或者不抢的选择，去收益较大的选择。甚至我们可以直接按这个套路写出代码：
     */
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root))
            return memo.get(root);
        // 抢， 然后去抢下下家
        int do_it = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，然后去下家
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }


    public static int rob_2(TreeNode root) {
        return robCore(root).val;
    }

    public static TreeNode robCore(TreeNode root) {
        if (root == null) {
            return robCore(new TreeNode(0));
        }

        if (root.left == null && root.right == null) {
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            return root;
        }

        root.left = robCore(root.left);
        root.right = robCore(root.right);
        root.val = Math.max(root.val + root.left.left.val + root.left.right.val + root.right.left.val + root.right.right.val, root.left.val + root.right.val);

        return root;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(2);
        r.left.right = new TreeNode(3);
        r.right = new TreeNode(3);
        r.right.right = new TreeNode(1);

//        System.out.println(rob(r));
    }
}
