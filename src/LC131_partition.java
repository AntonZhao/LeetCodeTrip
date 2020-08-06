import java.util.*;

public class LC131_partition {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(0, new ArrayList<>(), s, list);
        return list;
    }

    public void backtrack(int start, List<String> path, String s, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                backtrack(i + 1, path, s, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.addLast(2);
        l.addFirst(3);
        System.out.println(l);
        l.get(2);
    }
}