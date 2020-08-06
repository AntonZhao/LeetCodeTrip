import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC202_isHappy {
    /**
     * leetcode-202 快乐数 【简单】
     * 很快乐的一道题
     * 优秀题解：
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        while (sum != 1) {
            sum = 0;
            while (n != 0) {
                int temp = n % 10;
                n = (n - temp) / 10;
                sum += temp * temp;
            }
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        LC202_isHappy ll = new LC202_isHappy();
        System.out.println(ll.isHappy(19));
    }
}
