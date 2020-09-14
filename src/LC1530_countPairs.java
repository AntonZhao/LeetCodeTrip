public class LC1530_countPairs {

/*
 *   求每一个节点，左右的叶子节点，之间距离<=distance的组合，接着递归向左右子节点
 *   不会重复，因为每个节点的左右子组合都是不一样的，只让左的数目*右的数目
 */
    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    /** 自底向上的递归，用count数组统计和当前节点的距离为 i 的叶子节点数目，
     *  多于distance的不用考虑
     */
    private int[] dfs(TreeNode root, int distance) {
        if (root == null) {
            return new int[distance + 1];
        }
        int[] count = new int[distance + 1];
        if (root.left == null && root.right == null) {
            count[1] = 1;
            return count;
        }
        int[] leftCount = dfs(root.left, distance);
        int[] rightCount = dfs(root.right, distance);
        // 计算组合数
        for (int i = 1; i <= distance; i++) {
            for (int j = 0; j <= distance - i; j++) {
                res += leftCount[i] * rightCount[i];
            }
        }
        // 向上层返回，距离+1
        for (int i = 2; i <= distance; i++) {
            count[i] = leftCount[i - 1] + rightCount[i - 1];
        }

        return count;
    }
}
