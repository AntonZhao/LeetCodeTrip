public class LC214_shortestPalindrome {

    /**
     * 解法三
     * 寻找开头开始的最长回文串，我们回到更暴力的方法。
     *
     * 将原始字符串逆序，然后比较对应的子串即可判断是否是回文串。
     */
    public String shortestPalindrome(String s) {
        String re_s = new StringBuilder(s).reverse().toString();
        int len = s.length();
        int end = 1;
        for (int i = len; i > 1; i--) {
            if (s.substring(0, i).equals(re_s.substring(len - i, len))) {
                end = i;
                break;
            }
        }

        return new StringBuilder(s.substring(end)).reverse().toString() + s;
    }

    public static void main(String[] args) {
        LC214_shortestPalindrome ll = new LC214_shortestPalindrome();

        System.out.println(ll.shortestPalindrome("aacecaaa"));

        String s = "aacecaaa";
        System.out.println(s.substring(0));
    }

    /**
     * 根据解法一，我们其实就是在寻找从开头开始的最长回文串（这个很关键，后边所有的解法都是基于这个了），然后将末尾的除去最长回文串部分的几个字符倒置后加到原字符串开头即可。
     *
     * 我们只需要两个指针， i 和 j，i 初始化为 0，j 初始化为字符串长度减 1。然后依次判断 s[i] 和 s[j] 是否相同，相同的话， i 就进行加 1，j 进行减 1。 s[i] 和 s[j] 不同的话，只将 j 进行减 1。
     */
    public String shortestPalindrome_2(String s) {
        int i = 0, j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }

        //此时代表整个字符串是回文串
        if (i == s.length()) {
            return s;
        }
        //后缀
        String suffix = s.substring(i);
        //后缀倒置
        String reverse = new StringBuilder(suffix).reverse().toString();

        System.out.println("后缀: " + suffix);

        //递归 s[0,i),寻找开头开始的最长回文串，将其余部分加到开头和结尾
        return reverse + shortestPalindrome_2(s.substring(0, i)) + suffix;
    }

    /**
     * 超时了
     */
    public String shortestPalindrome__n_n(String s) {
        int start = 0;
        for (int i = s.length(); i >= 1; i--) {
//            System.out.println(i+ " " + s.substring(0, i));
            if (isValidPalindrome(s.substring(0, i))) {
                start = i;
                break;
            }
        }
        String res = s;
        for (int i = start; i < s.length(); i++) {
            res = s.charAt(i) + res;
        }

        return res;
    }

    private boolean isValidPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }


}
