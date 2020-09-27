public class LC968_minCameraCover {
    /**
     * 状态0：当前节点安装相机的时候，需要的最少相机数
     * 状态1： 当前节点不安装相机，但是能被覆盖到的时候，需要的最少相机数
     * 状态2：当前节点不安装相机，也不能被覆盖到的时候，需要的最少相机数
     */
    public int minCameraCover(TreeNode root) {
        int[] ans = minCamera(root);
        return Math.min(ans[0], ans[1]);
    }

    public int[] minCamera(TreeNode root) {
        int[] dp = new int[3];
        if (root == null) {
            dp[0] = Integer.MAX_VALUE / 2;
            dp[2] = Integer.MAX_VALUE / 2;
            return dp;
        }
        int[] left = minCamera(root.left);
        int[] right = minCamera(root.right);
        // 1. 安装相机，其左孩子节点和右孩子节点都可以安装或者不装，但是总相机数+1
        dp[0] = Math.min(left[0], Math.min(left[1], left[2])) +     // 左孩子选择装或者不装
                Math.min(right[0], Math.min(right[1], right[2])) +  // 右孩子选择装或者不装
                1;

        // 2. 不安装相机，但是能被覆盖到，说明其孩子节点至少有一个安装了相机，因为自己不安装相机，如果孩子节点也不安装，那个节点只能是已被覆盖到的
        dp[1] = Math.min(
                left[0] + Math.min(right[0], right[1]), // 左孩子节点安装，右孩子节点没安装
                right[0] + Math.min(left[0], left[1])); // 右孩子节点安装，左孩子节点没安装

        // 3. 不安装相机，也不能被覆盖到，说明其孩子节点都没有安装相机，因为自己没有安装相机，其孩子节点也必须是已被覆盖到的
        dp[2] = left[1] + right[1];
        System.out.println("当前节点为：" + root.val + "， dp数组为：" + dp[0] + " " + dp[1] + " " + dp[2]);
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE / 2 + Integer.MAX_VALUE / 2);
    }
}
