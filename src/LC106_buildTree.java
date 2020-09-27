import java.util.HashMap;
import java.util.Map;

public class LC106_buildTree {
    Map<Integer, Integer> inMap;
    int[] inOrder;
    int[] postOrder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inOrder = inorder;
        this.postOrder = postorder;
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int inBegin, int inEnd, int postBegin, int postEnd) {
        if (inBegin > inEnd || postBegin > postEnd)
            return null;

        int root = postOrder[postEnd];
        int index = inMap.get(root);

        TreeNode node = new TreeNode(root);
        node.left = helper(inBegin, index - 1, postBegin, postBegin + index - inBegin - 1);
        node.right = helper(index + 1, inEnd, postBegin + index - inBegin, postEnd - 1);
        return node;
    }
}
