public class LC459_repeatedSubstringPattern {
    /**
     * 字符串匹配，很神奇的方法
     */
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    /**
     * 枚举方法
     */
    public boolean repeatedSubstringPattern_enum(String s) {
        int length = s.length();

        for (int i = 1; i * 2 <= length; i++) {
            if (length % i == 0) {
                boolean match = true;
                for (int j = i; j < length; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC459_repeatedSubstringPattern ll = new LC459_repeatedSubstringPattern();

        System.out.println(ll.repeatedSubstringPattern("abaababaab"));
    }
}
