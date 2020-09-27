import java.util.ArrayList;
import java.util.List;

public class LC501_findMode {
    List<Integer> list;
    int preVal = 0, currTimes = 0, maxTimes = 0;

    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        inorderTraverse(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    private void inorderTraverse(TreeNode node) {
        if (node == null) return;
        inorderTraverse(node.left);

        if (node.val == preVal) {
            currTimes++;
        } else {
            preVal = node.val;
            currTimes = 1;
        }

        if (currTimes == maxTimes) {
            list.add(node.val);
        } else if (currTimes > maxTimes) {
            maxTimes = currTimes;
            list.clear();
            list.add(node.val);
        }

        inorderTraverse(node.right);
    }
}
