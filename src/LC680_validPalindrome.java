public class LC680_validPalindrome {
    /**
     * leetcode-680 验证回文字符串【简单】
     * 发现不一样就删掉试试咯
     * 优秀题解：
     */
    public boolean validPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return isPalindrome(s.substring(begin + 1, end + 1)) || isPalindrome(s.substring(begin, end));
            }
            begin++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        while (begin <= end) {
            if (s.charAt(begin++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC680_validPalindrome ll = new LC680_validPalindrome();
        System.out.println(ll.validPalindrome("abc"));
    }
}
