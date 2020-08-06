public class LC836_isRectangleOverlap {
    /**
     * leetcode-836 矩形折叠【简单】
     * 思路1：先固定一个矩形，如何不重叠，另外一个矩形可能出现在上下左右四个方向，分别拿这四个条件做判断，凡是符合其中一个，那么就是不重叠的。
     * 思路2：将矩形的x和y分别投在x轴和y轴上，两个矩形的x/y 需要有交集才能重合，以此为判断条件。
     * 优秀题解：
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0]
                || rec1[0] >= rec2[2]
                || rec1[1] >= rec2[3]
                || rec1[3] <= rec2[1]);
    }

    public boolean isRectangleOverlap_2(int[] rec1, int[] rec2) {
        return (Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2])) &&
               (Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]));
    }
}
