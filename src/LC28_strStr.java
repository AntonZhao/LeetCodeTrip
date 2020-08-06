public class LC28_strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int i = 0;
        int j = 0;
        for (i = 0; i < haystack.length(); i++) {
            if (j == needle.length()) {
                return i - needle.length();
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - needle.length();
        }
        return -1;
    }




    public static void main(String[] args) {
        LC28_strStr ll = new LC28_strStr();
        String h = "mississippi";
        String n = "issip";
        System.out.println(ll.strStr(h, n));
    }
}
