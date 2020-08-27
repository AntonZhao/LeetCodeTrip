import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC17_letterCombinations_ {
    // 深度优先
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(digits, map, res, 0, "");

        return res;
    }

    private void dfs(String digits, HashMap<Character, String> map, ArrayList<String> res, int depth, String curr) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }

        String s = map.get(digits.charAt(depth));
        for (char c : s.toCharArray()) {
            dfs(digits, map, res, depth + 1, curr + c);
        }
    }

    // 广度优先

}
