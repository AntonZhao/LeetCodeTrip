import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30_findSubstring {
    /**
     * 思路二：
     * 滑动窗口！
     * 我们一直在 s 维护着所有单词长度总和的一个长度队列！
     * 时间复杂度：O(n)
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;

        int word_length = words[0].length();
        int word_num = words.length;
        int all_len = word_length * word_num;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // i从0到word_length是考虑到单词截断情况，所以错开依次遍历
        for (int i = 0; i < word_length; i++) {
            // 维护滑动窗口的左右边界，从i开始
            int left = i, right = i, count = 0;
            Map<String, Integer> temp_map = new HashMap<>();
            while (right + word_length <= s.length()) {
                // 在右边界取词,放进当前维护的map里，增大右边界范围，更新数量
                String word = s.substring(right, right + word_length);
                temp_map.put(word, temp_map.getOrDefault(word, 0) + 1);
                right += word_length;
                count++;

                // 新增的词，要考虑合不合适，可以理解为更新左边界
                // 更新到当前维护临时map的是真正map的一个子集，包括空集
                while (temp_map.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                    //收缩左边界，维护临时map,减小计数器
                    String temp_word = s.substring(left, left + word_length);
                    temp_map.put(temp_word, temp_map.getOrDefault(temp_word, 0) - 1);
                    left += word_length;
                    count--;
                }

                // 满足个数条件，保存答案
                if (count == word_num) res.add(left);
            }
        }

        return res;
    }


    /**
     * 思路一：
     * 因为单词长度固定的，我们可以计算出截取字符串的单词个数是否和 words 里相等，所以我们可以借用哈希表。
     * 一个是哈希表是 words，一个哈希表是截取的字符串，比较两个哈希是否相等！
     * 因为遍历和比较都是线性的，所以时间复杂度：O(n^2)
     */
    public List<Integer> findSubstring_slow(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;

        int word_length = words[0].length();
        int word_num = words.length;
        int all_len = word_length * word_num;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String curr = s.substring(i, i + all_len);
            HashMap<String, Integer> temp_map = new HashMap<>();
            for (int j = 0; j < curr.length(); j += word_length) {
                String temp_word = curr.substring(j, j + word_length);
                temp_map.put(temp_word, temp_map.getOrDefault(temp_word, 0) + 1);
            }
            if (map.equals(temp_map))
                res.add(i);
        }
        return res;
    }
}
