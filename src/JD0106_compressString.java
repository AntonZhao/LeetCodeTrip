public class JD0106_compressString {
    public String compressString(String S) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < S.length(); ) {
            char c = S.charAt(i);
            int num = i + 1;
            while(num < S.length() && S.charAt(num) == c) {
                num++;
            }
            builder.append(c);
            builder.append((int)(num - i + 1));
            i = num;
        }
        if (builder.length() >= S.length()) {
            return S;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        JD0106_compressString jj = new JD0106_compressString();
        System.out.println(jj.compressString("bbbcdaaaaaaaaaaaaaabbbbbbbbbbbbbbbaeffffffffffffffffffffffff"));
    }
}
