/**
 * 爬楼梯
 */
public class LC70_climbStairs {
    public int climbStairs(int n) {
        int a = 1, b = 1;

        for(int i = 2; i <= n; i++){
            int temp = b;
            b = a + b;

            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
