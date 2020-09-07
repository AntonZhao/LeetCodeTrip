package exam;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class XHS3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X;
        X = scanner.nextInt();
        int L, T, N;
        L = scanner.nextInt();
        T = scanner.nextInt();
        N = scanner.nextInt();
        HashSet<Integer> dangers = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int l = scanner.nextInt();
            dangers.add(l);
        }

        // code
        // dp[i] 代表在i位置停留过的危险区域数量
        LinkedList<Integer> list = new LinkedList<>();
        int[] dp = new int[T + 1];
        for (int i = 0; i <= T; i++) {
            dp[i] = -1;
            list.add(-1);
        }
        dp[0] = 0;
        list.set(0, 0);
        for (int i = 1; i <= T; i++) {
            boolean isDanger = dangers.contains(i);
            int start = 0;
            int end = i - L;

            if (end < 0) continue;

            int min = Integer.MAX_VALUE;
            for (int j = start; j <= end; j++) {
                if (list.get(j) != -1) {
                    min = Math.min(min, list.get(j));
                }
            }
            list.set(i, isDanger ? 1 + min : min);
        }

        for (int i = T + 1; i <= X; i++) {
//            for (int j = 0; j <= T; j++) {
//                System.out.print(list.get(j) + " ");
//            }
            System.out.println();

            boolean isDanger = dangers.contains(i);
            int start = 0;
            int end = T - L;

            int min = Integer.MAX_VALUE;
            for (int j = start + 1; j <= end + 1; j++) {
                if (list.get(j) != -1) {
                    min = Math.min(min, list.get(j));
                }
            }
            int value = isDanger ? 1 + min : min;
            list.removeFirst();
            list.addLast(value);
        }

        System.out.println(list.getLast());
    }
}
