import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class LC1026_maxAncestorDiff {
    private int res;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        res = 0;
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode node, int max, int min) {
        if (node == null) return;

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        // 如果到达了叶子节点，则计算一次差值
        if (node.left == null && node.right == null) {
            res = Math.max(res, Math.abs(max - min));
        }

        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }

    public static void main(String[] args) {
        TreeMap<Character, List<Integer>> map = new TreeMap<>((o1, o2) -> o2 - o1);
    }

}
