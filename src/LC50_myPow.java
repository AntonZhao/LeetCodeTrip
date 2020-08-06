public class LC50_myPow {
    /**
     * leetcode-50 Pow(x,n) 【中等】
     * 掌握二分的方法即可
     * 优秀题解：
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return pow(x, n);
    }

    public double pow(double x, int n) {
        if (n == 0)
            return 1.0;
        double half = pow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        return half * half * x;
    }

    public static void main(String[] args) {
        LC50_myPow ll = new LC50_myPow();
        System.out.println(ll.myPow(2, 10));
    }
}
