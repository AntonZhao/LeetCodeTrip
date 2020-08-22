import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true; // 从左往右

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (flag) {
                    list.addLast(node.val);
                }  else {
                    list.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            res.add(list);
            flag = !flag;
        }

        return res;
    }

    public static void main(String[] args) {
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node20 = new TreeNode(20);
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node7 = new TreeNode(7);
//
//        node3.left = node9;
//        node3.right = node20;
//        node20.left = node15;
//        node20.right = node7;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        LC103_zigzagLevelOrder ll = new LC103_zigzagLevelOrder();
        List<List<Integer>> list = ll.zigzagLevelOrder(node1);
        for (List<Integer> integerList : list) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
