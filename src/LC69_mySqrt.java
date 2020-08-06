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
}
