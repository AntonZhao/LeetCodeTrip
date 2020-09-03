public class JZ20_isNumber {
    public boolean isNumber(String s) {
        s = s.trim();

        char[] chars = s.toCharArray();

        boolean eSeen = false;
        boolean pointSeen = false;
        boolean numberSeen = false;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                numberSeen = true;
            } else if (c == '.') {
                if (eSeen || pointSeen)
                    return false;
                pointSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numberSeen)
                    return false;
                eSeen = true;
                numberSeen = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E')
                    return false;
            } else {
                return false;
            }
        }

        return numberSeen;
    }

}
