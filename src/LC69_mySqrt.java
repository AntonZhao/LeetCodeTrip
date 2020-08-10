public class LC69_mySqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
//            long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static int mySqrt_Newton(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

    /**
     * 求一个数的平方根，精确到0.01
     */

    public static double mySqrt_double(int num) {
        if (num < 0) return 0;

        double left = 0, right = num / 2;

        while (left < right) {
            double mid = (left + right) / 2;
            if (Math.abs(mid*mid - num) <= 0.01)
                return mid;
            if ((mid * mid - num) > 0.01) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt_double(8));
        System.out.println(mySqrt_double(9));
        System.out.println(Math.sqrt(8));
    }
}
