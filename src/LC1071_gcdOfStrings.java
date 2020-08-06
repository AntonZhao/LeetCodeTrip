public class LC1071_gcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for(int i = Math.min(len1, len2); i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String x = str1.substring(0, i);
                if (check(x, str1) && check(x, str2)) {
                    return x;
                }
            }
        }
        return "";
    }

    public boolean check(String x, String str) {
        int times = str.length() / x.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(x);
        }
        return builder.toString().equals(str);
    }
}
