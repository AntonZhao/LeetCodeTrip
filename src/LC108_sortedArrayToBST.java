import java.util.Random;

public class LC108_sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        // int mid = (left + right + 1) / 2;    // 选择右边节点
        // int mid = (left + right) / 2;        // 选择左边节点
        int mid = (left + right + new Random().nextInt(2)) / 2;        // 选择左或者右节点

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }
}
