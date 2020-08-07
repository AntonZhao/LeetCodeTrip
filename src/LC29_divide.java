public class LC29_divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }

        // 结果是否为负数
        boolean isNegative = (dividend ^ divisor) < 0 ? true : false;
        // 都转为负数，因为负数的范围比正数大1
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int res = div(dividend, divisor);
        return isNegative ? -res : res;
    }

    private int div(int dividend, int divisor) {
        if (dividend > divisor) return 0;

        int tmp = divisor;
        int count = 1;

        while (tmp + tmp < 0 && dividend <= tmp + tmp) {
            count += count;
            tmp += tmp;
        }
        return count + div(dividend - tmp, divisor);
    }


    public static void main(String[] args) {
        LC29_divide solution = new LC29_divide();

//        int dividend = -2147483648;
//        int divisor = -1;

        int dividend = 2147483647;
        int divisor = 2;


        System.out.println(solution.divide(2147483647, 2));
        System.out.println(solution.divide(-2147483648, -1));
        System.out.println(solution.divide(23, 3));
        System.out.println(solution.divide(-2147483648, 2));


    }
}
