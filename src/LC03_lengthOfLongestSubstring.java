import java.util.HashMap;

public class LC03_lengthOfLongestSubstring {
    /**
     * leetcode-3 无重复字符的最长子串 【中等】
     * 我觉得滑动窗口是最棒的方法了
     * 优秀题解：
     */

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
