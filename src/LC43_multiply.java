public class LC43_multiply {
    /**
     * 2、 优化竖式
     * 乘数 num1 位数为 M，被乘数 num2 位数为 N， num1 x num2 结果 res 最大总位数为 M+N
     * num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
     */

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                res[i + j + 1] += (n1 * n2) % 10;
                res[i + j] += (n1 * n2) / 10;
            }
        }

        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            if (i == 0 && res[0] == 0 && carry == 0) continue;
            int total = carry + res[i];
            carry = total / 10;
            result.append(total % 10);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        LC43_multiply ll = new LC43_multiply();
        System.out.println(ll.multiply("123", "345"));
    }


    /**
     * 1、 普通乘法竖式
     */
    public String multiply_1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < num2.length() - i - 1; j++)
                temp.append("0");

            int n2 = num2.charAt(i) - '0';
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            if (carry != 0) temp.append(carry);

            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0; i--, j--) {

            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (n1 + n2 + carry) % 10;
            res.append(sum);
            carry = (n1 + n2 + carry) / 10;
        }
        return res.reverse().toString();
    }
}
