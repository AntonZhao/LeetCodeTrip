public class LC8_myAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0, sign = 1, total = 0;

        // 1. 处理空格
        while(index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        // 2. 处理符号
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        // 3. 处理数字
        while (index < str.length()) {
            int digit = str.charAt(index++) - '0';
            if (digit < 0 || digit > 9) {
                return total * sign;
            }
            // 4. 如果乘10会爆掉 或者 乘十不爆，加上digit会爆
            if (Integer.MAX_VALUE / 10 < total ||
                    Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10*total + digit;
        }

        return total * sign;
    }

    public static void main(String[] args) {
        LC8_myAtoi ll = new LC8_myAtoi();
        System.out.println(ll.myAtoi("-91283472332"));
        int i = 912834723;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE / 10 < i);
    }
}
