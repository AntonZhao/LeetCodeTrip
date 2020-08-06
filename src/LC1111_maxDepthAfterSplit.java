public class LC1111_maxDepthAfterSplit {
    /**
     * leetcode-1111 有效括号的嵌套深度【中等】
     * 思路：1.根据 depth(A + B) = max(depth(A), depth(B)) 这个定义，整体的「嵌套深度」取决于子序列的「嵌套深度」的最大者；
     *      2.要使得 max(depth(A), depth(B)) 的可能取值最小，分析示例的时候提到，这很像一棵二叉树，要使得二叉树的深度最小，那么就需要该二叉树平衡，
     *          一个可行的做法是：把栈中连续出现的左括号 ( 根据奇偶性分到不同的组，右括号随与之匹配左括号的组号；
     *      3.如果出现 () 这种子序列，即左括号后面连着出现了右括号，其实分在那一组都是没有关系的，因为它的存在不会使得「嵌套深度」更深。
     * 优秀题解：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/solution/qian-tao-shen-du-wan-cheng-gua-hao-pi-pei-wen-ti-s/
     */
    public int[] maxDepthAfterSplit(String seq) {

        int len = seq.length();
        int[] res = new int[len];

        // 嵌套深度，栈的当前高度
        int depth = 0;

        // 在 Java 里，seq.charAt(i) 函数会做下标越界检查，
        // 因此先转换成字符数组是常见的做法
        char[] charArray = seq.toCharArray();

        for (int i = 0; i < len; i++) {
            // 遍历到左括号，连续括号个数加 1，
            if (charArray[i] == '(') {
                depth++;
                // % 2 也可以写成 & 1，为了保证语义清楚，写 % 2
                res[i] = depth % 2;
            } else {
                // 遍历到右括号，与当前栈顶左括号分在一组，因此先取模，再 --
                // 这一步希望大家多体会，很有意思
                res[i] = depth % 2;
                depth--;
            }
        }
        return res;
    }
}
