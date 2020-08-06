public class LC11_maxArea {
    /**
     * leetcode-11 盛水最多的容器【中等】
     * 1.暴力方法：「嵌套循环」两个位置指针，枚举出所有的可能，选个最大的
     * 2.一个循环
     * 优秀题解：
     */
    public int maxArea_bruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(temp, maxArea);
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int max = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            int minHeight = height[start] < height[end] ? height[start++] : height[end--];
            max = Math.max(max, (end - start + 1) * minHeight);
        }
        return max;
    }
}
