package exam;

public class LC5479_thousandSeparator {
    public static String thousandSeparator(int n) {
        String s = String.valueOf(n);
        char[] chs = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        int flag = 0;
        for (int i = chs.length - 1; i >= 0; i--) {
            builder.append(chs[i]);
            flag++;
            if (flag == 3 && i > 0) {
                builder.append('.');
                flag = 0;
            }
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(987));
        System.out.println(thousandSeparator(1234));
        System.out.println(thousandSeparator(123456789));
        System.out.println(thousandSeparator(0));
        System.out.println(thousandSeparator(-1234));
    }
}
