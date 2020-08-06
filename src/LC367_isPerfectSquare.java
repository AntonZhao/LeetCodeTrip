import java.util.Scanner;

public class LC367_isPerfectSquare {
    public static boolean isPerfectSquare(int n) {
        if (n <= 1) return true;
        long left = 0;
        long right = n / 2;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid > n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left * left == n;
    }

    public static boolean isPerfectSquare_right(int n) {
        if (n <= 1) return true;
        long left = 0;
        long right = n / 2;
        while (left <= right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid == n) {
                return true;
            } else if (mid * mid > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * This is a math problem：
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 + 3 + 5 + 7 + 9
     * 36 = 1 + 3 + 5 + 7 + 9 + 11
     * ....
     * so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
     * 等差数列。。。
     */
    public boolean isPerfectSquare_NB(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    //  牛顿法
    public static boolean isPerfectSquare_newton(int num) {
        long x = 1;
        while (x * x != num) {
            x = (x + num / x) / 2;
            System.out.println(x + " " + x * x);
            if (x * x < num) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(isPerfectSquare(n));
        }

    }
}
