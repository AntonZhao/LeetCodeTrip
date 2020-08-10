package exam;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int N = Integer.valueOf(s);

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        // 偶数肯定全拆成2，所以偶数/2
        // 奇数先拆2再3

        long res = 0;
        for (int num : nums) {
            if (num == 1) {
                continue;
            } else if (num <= 3) {
                res += 1;
            } else {
//                if (num % 2 == 0) {
//                    res += num / 2;
//                } else {
//                    // 到了这里，num是大于3的奇数，至少是5
//                    res += 1 + (num - 3) / 2;
//                }
                res += num / 2;
            }
        }

        System.out.println(res);

        scanner.close();
    }
}
