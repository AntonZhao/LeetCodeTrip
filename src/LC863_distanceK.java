import java.util.*;

public class LC863_distanceK {
    /**
     * 这道题不错的，dfs和bfs全考了，然后逻辑还不是那么复杂。
     */


    Map<TreeNode, TreeNode> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (K == 0) {
            List<Integer> list = Arrays.asList(target.val);
            return list;
        }
        map = new HashMap<>();
        fillMap(root, null);

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        visited.add(target);
        if (target.left != null) {
            queue.add(target.left);
            visited.add(target.left);
        }
        if (target.right != null) {
            queue.add(target.right);
            visited.add(target.left);
        }
        if (map.get(target) != null) {
            queue.add(map.get(target));
            visited.add(map.get(target));
        }

        for (int i = 1; i < K; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if (map.get(node) != null && !visited.contains(map.get(node))) {
                    queue.add(map.get(node));
                    visited.add(map.get(node));
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;

    }

    public void fillMap(TreeNode node, TreeNode parent) {
        if (node != null) {
            map.put(node, parent);
            fillMap(node.left, node);
            fillMap(node.right, node);
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;

        node5.left = node6;
        node5.right = node2;

        node1.left = node0;
        node1.right = node8;

        LC863_distanceK ll = new LC863_distanceK();
        List<Integer> list = ll.distanceK(node3, node5, 3);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
