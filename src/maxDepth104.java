import java.util.LinkedList;

public class maxDepth104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        TreeNode node = root;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int front = 0;
        int rear = list.size();
        int floor = 0;
        while(!list.isEmpty()) {
            node = list.poll();
            front++;
            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }

            if (front == rear) {
                front = 0;
                rear = list.size();
                floor++;
            }
        }

        return floor;
    }

    public static int maxDepth_interal(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int left = maxDepth_interal(root.left);
            int right = maxDepth_interal(root.right);
            return Math.max(left, right) + 1;
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

//        System.out.println(maxDepth(root));
        System.out.println(maxDepth_interal(root));
    }
}
