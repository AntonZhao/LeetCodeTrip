public class LC541_reverseStr {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        for (int start = 0; start < s.length(); start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, chs.length - 1);
            while (i < j) {
                char temp = chs[i];
                chs[i++] = chs[j];
                chs[j--] = temp;
            }
        }
        return new String(chs);
    }

}