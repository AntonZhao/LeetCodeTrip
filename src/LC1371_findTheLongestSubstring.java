import java.util.Arrays;

public class LC1371_findTheLongestSubstring {
    /**
     * leetcode-1371 每个原因包含偶数次的最长子字符串【中等】
     * 利用奇偶性，两个元音重复出现后，status是一样的！！！
     * 优秀题解：官方题解
     */
    public int findTheLongestSubstring(String s) {
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int res = 0, status = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            System.out.print(ch + "  ");
            if (pos[status] >= 0) {
                res = Math.max(res, i + 1 - pos[status]);
                System.out.println("更新结果：res = " + res + " 位置 = " + (i + 1));
            } else {
                // 小于0说明是个新的状态
                // 换言之，pos每个位置存储的是这个状态最小的位置
                pos[status] = i + 1;
                System.out.println("更新状态：status = " + status + " 位置 = " + (i + 1));
            }
//            for (int j = 0; j < pos.length; j++) {
//                System.out.print(pos[j] + " ");
//            }
//            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        LC1371_findTheLongestSubstring ll = new LC1371_findTheLongestSubstring();
        System.out.println(ll.findTheLongestSubstring("eleetminicoworope"));
    }
}
