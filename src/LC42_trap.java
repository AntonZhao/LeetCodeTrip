public class LC42_trap {
    /**
     * leetcode-42 接雨水【困难】
     * 思路：找每个位置的左右两个方向的最大高度，着实牛逼，自己品
     * 时间复杂度：O(N)
     * 题解：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
     */
    // 备忘录优化
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;

        int len = height.length;
        int[] l_max = new int[len];
        int[] r_max = new int[len];
        l_max[0] = height[0];
        r_max[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }
}
