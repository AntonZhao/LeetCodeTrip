import java.util.*;

/**
 * 336. 回文对 [困难]
 *
 */
public class LC336_palindromePairs {
    List<String> wordsRev = new ArrayList<>();
    Map<String, Integer> index = new HashMap<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            // 存储每个字符串的逆序
            String rev = new StringBuilder(words[i]).reverse().toString();
            wordsRev.add(rev);
            // 存储每个逆序串的下标
            index.put(rev, i);
        }

        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 当前字符串以及它的长度，假设当前字符串是较长的
            String word = words[i];
            int m = word.length();
            if (m == 0) continue;

            // 为什么j要遍历到m呢？
            // 就是为了处理空字符串的情况
            for (int j = 0; j <= m; j++) {
                // 当前字符串拆成两个子串，t1 t2，如果t1是回文串，只要在字符串集合找到t2的回文串，那么就成功一对
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int leftOne = findWordIndex(word, j, m);
                    if (leftOne != -1 && leftOne != i) {
                        res.add(Arrays.asList(leftOne, i));
                    }
                }
                // 当前字符串拆成两个子串，t1 t2，如果t2是回文串，只要在字符串集合找到t1的回文串，那么就成功一对
                if (isPalindrome(word, j, m - 1)) {
                    int rightOne = findWordIndex(word, 0, j);
                    if (rightOne != -1 && rightOne != i) {
                        res.add(Arrays.asList(i, rightOne));
                    }
                }
            }
        }

        return res;
    }

    int findWordIndex(String word, int left, int right) {
//        System.out.println("String:  " + word + ",  left:  " + left + ",  right:  " + right);
        String substring = word.substring(left, right);
        return index.getOrDefault(substring, -1);
    }

    boolean isPalindrome(String word, int left, int right) {
//        System.out.println("String:  " + word + ",  left:  " + left + ",  right:  " + right);
        int length = right - left + 1;
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(left + i) != word.charAt(right - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] ss = {"abcd", "dcba", "lls", "s", "sssll"};
//        String[] ss = {"bat", "tab", "cat"};
//        String[] ss = {"a", ""};
        String[] ss = {"a", "abc", "aba", ""};
        LC336_palindromePairs solution = new LC336_palindromePairs();

        List<List<Integer>> lists = solution.palindromePairs(ss);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
