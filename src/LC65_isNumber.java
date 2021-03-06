public class LC65_isNumber {
    // 脑容量限制，有限状态机的方法就别去深究了。。
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numberSeen = true;
            } else if (c == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberSeen = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen;
    }
}
