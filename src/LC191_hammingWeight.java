import java.util.Scanner;

public class LC191_hammingWeight {
    // 1.  位操作
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            // n & n-1 可以清掉最低位的1
            n &= n-1;
        }
        return res;
    }
    // 2.循环和位移动
    public int hammingWeight_2(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                res++;
            }
            mask <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(hammingWeight(n));
        }
        sc.close();
    }
}
