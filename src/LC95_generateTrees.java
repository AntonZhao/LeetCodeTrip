import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II  中等
 */
public class LC95_generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int begin, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        if (begin > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 枚举可行根节点
        for (int i = begin; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(begin, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }
}
