import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC76_minWindow {
    /**
     * leetcode-76 最小覆盖子串【困难】
     * 请看注释
     * 优秀题解：https://leetcode.com/problems/minimum-window-substring/discuss/26835/Java-4ms-bit-97.6
     */
    public String minWindow(String s, String t) {
        char[] s_array = s.toCharArray(), t_array = t.toCharArray();
        int res_length = Integer.MAX_VALUE, res_start = 0;
        int start = 0, end = 0;

        // map用来存每个字符出现的次数
        // count是要出现的所有字符的长度
        int[] map = new int[256];
        for (char c : t_array) {
            map[c] += 1;
        }
        int count = t_array.length;

        while (end < s.length()) {
            // 如果end是要匹配的字符，那么减少count
            // 也需要减少map中该字符的值，不管是不是要匹配的
            if (map[s_array[end]] > 0) {
                count--;
            }
            map[s_array[end]]--;
            // 如果当前匹配成了，左指针左移
            // 更新结果 和 map
            while (count == 0) {
                if (end - start + 1 < res_length)  {
                    res_length = end - start + 1;
                    res_start = start;
                }
                map[s_array[start]]++;
                if (map[s_array[start]] > 0) {
                    count++;
                }
                start++;
            }
            // 匹配不成了，右指针右移
            end++;
        }

        if (res_length == Integer.MIN_VALUE)
            return "";
        return s.substring(res_start, res_length + res_start);
    }



    // 自己的超时方法
    // 我好垃圾啊
    // 好垃圾啊
    // 垃圾啊
    // 圾啊
    // 啊
    Map<Character, Integer> map = new HashMap<>();

    public String minWindow_TL(String s, String t) {
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int right = t.length() - 1;
        String res = "123456789";
        for (int left = 0; left < s.length() && right < s.length(); left++) {
            while (!hasAllChars(s, left, right)) {
                right++;
                if (right >= s.length())
                    break;
            }
            if (right >= s.length())
                break;
            while (hasAllChars(s, left, right)) {
                left++;
            }
//            res = s.substring(left - 1, right + 1);
            if (res == "123456789") {
                res = s.substring(left - 1, right + 1);
            } else {
                if (right - left + 2 < res.length()) {
                    res = s.substring(left - 1, right + 1);
                }
            }
        }

        return res == "123456789" ? "" : res;
    }

    private boolean hasAllChars(String s, int left, int right) {
        Map<Character, Integer> temp = new HashMap<>(map);
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (temp.containsKey(c)) {
                temp.put(c, temp.get(c) - 1);
            }
        }
        int sum = 0;
        for (Integer value : temp.values()) {
            if (value >= 0) sum += value;
        }
        return sum > 0 ? false : true;
    }

    public static void main(String[] args) {
        LC76_minWindow ll = new LC76_minWindow();

        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(ll.minWindow(s, t));
    }


}
