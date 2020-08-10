public class LC696_countBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int last = 0, cur = 0, res = 0;
        char curChar = chars[0];
        for (char c : chars) {
            if (c != curChar) {
                last = cur;
                cur = 0;
                curChar = c;
            }
            cur++;
            if (last >= cur) res++;

            System.out.println("last: " + last + "  cur: " + cur + "  res: " + res);
        }
        return res;
    }

    public static void main(String[] args) {
        LC696_countBinarySubstrings ll = new LC696_countBinarySubstrings();

        System.out.println(ll.countBinarySubstrings("00110011"));
        System.out.println(ll.countBinarySubstrings("10101"));
        System.out.println(ll.countBinarySubstrings("1"));
        System.out.println(ll.countBinarySubstrings("0"));
    }
}
