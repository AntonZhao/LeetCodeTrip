import java.util.HashMap;
import java.util.Map;

public class LC105_buildTree {
    Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        inMap = new HashMap<>();
        // 要根据中序获得左右子树的范围
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = builder(preorder, 0, len - 1, inorder, 0, len - 1);
        return root;
    }

    private TreeNode builder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd)
            return null;
        // 前序序列的第一个就是当前子树的根节点，so，拿出来建立节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        if (preStart == preEnd) {
            return root;
        } else {
            // 获取当前根节点在「当前中序序列」中的位置，并且获得左右子树的数目
            /**
             举例 preorder:3,9,20,15,7  inorder:9,3,15,20,7
             当前根节点是3，根据inorder得到 左边有一个，右边有三个

             根据leftNodes rightNodes rootIndex 更新数组范围，表示方法不唯一
             */
            int rootIndex = inMap.get(rootVal);
            int leftNodes = rootIndex - inStart;
            int rightNodes = inEnd - rootIndex;
            TreeNode leftTree = builder(preorder, preStart + 1, preStart + leftNodes, inorder, rootIndex - leftNodes, rootIndex - 1);
            TreeNode rightTree = builder(preorder, preStart + leftNodes + 1, preEnd, inorder, rootIndex + 1, rootIndex + rightNodes);
            root.left = leftTree;
            root.right = rightTree;
            return root;
        }

    }

    public static void main(String[] args) {
        LC105_buildTree ll = new LC105_buildTree();
        int[] pre = {1, 2, 3};
        int[] in = {2, 3, 1};
        TreeNode root =  ll.buildTree(pre, in);
        System.out.println(root.val);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
