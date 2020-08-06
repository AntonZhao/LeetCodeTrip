import java.util.*;

public class LC17_letterCombinations {
    // 递归方法
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new LinkedList<>();
        backtrack(0, "", map, digits, res);
        return res;
    }

    private void backtrack(int depth,
                           String cur,
                           Map<Character, String> map,
                           String digits,
                           List<String> res) {
        // terminator
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        }
        // process
        char c = digits.charAt(depth);
        for (char cc : map.get(c).toCharArray()) {
            backtrack(depth + 1, cur + cc, map, digits, res);
        }
        // drill down

        // reverse state
    }

    // 广度优先方法, 使用队列
    public List<String> letterCombinations_bfs(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) {
            return res;
        }

        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        while (res.peek().length() != digits.length()) {
            String remove = res.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                res.addLast(remove + c);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC17_letterCombinations ll = new LC17_letterCombinations();
        System.out.println(ll.letterCombinations("234"));
        System.out.println(ll.letterCombinations_bfs("234"));
    }
}
