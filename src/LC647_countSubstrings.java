public class LC647_countSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // 总数奇数个 1 3 5 7
            res += count(chars, i, i);
            // 总数偶数个 2 4 6  8
            if (i > 0 && chars[i - 1] == chars[i]) {
                res += count(chars, i - 1, i);
            }
        }

        return res;
    }

    private int count(char[] chars, int left, int right) {
        int counter = 0;
        while (left >= 0 && right < chars.length) {
            if (chars[left--] == chars[right++]) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        LC647_countSubstrings ll = new LC647_countSubstrings();
        System.out.println(ll.countSubstrings("aaa"));
        System.out.println(ll.countSubstrings("abc"));
    }
}
