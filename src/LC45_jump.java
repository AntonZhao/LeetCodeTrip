public class LC45_jump {
    /**
     * leetcode-45 跳跃游戏2 【困难】
     * 贪婪算法，我们每次在可跳范围内选择可以使得跳的更远的位置。
     * 可能不到end就跳走了，但都是在上一个起点的可跳区间内，所欲算作一跳
     * 优秀题解：
     */
    public int jump(int[] nums) {
        int step = 0;
        int maxPos = 0;
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                step++;
            }
            System.out.println(maxPos + " " + end + " " + step);
        }
        return step;
    }

    public static void main(String[] args) {
        LC45_jump ll = new LC45_jump();
        int[] nn = {2, 3, 1, 1, 4, 2, 1};
        System.out.println(ll.jump(nn));
    }
}
