package exam;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] fixed = new int[m];
        int[] unFixed = new int[n - m];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int temp = scanner.nextInt();
            fixed[i] = temp;
            set.add(temp);
        }

        int pointer = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                unFixed[pointer++] = i;
            }
        }

        StringBuilder builder = new StringBuilder();
        int fixedPointer = 0, unFixedPointer = 0;
        while (fixedPointer != m && unFixedPointer != n - m) {
            if (fixed[fixedPointer] < unFixed[unFixedPointer]) {
                builder.append(fixed[fixedPointer++] + " ");
            } else {
                builder.append(unFixed[unFixedPointer++] + " ");
            }
        }
        while (fixedPointer < m) {
            builder.append(fixed[fixedPointer++] + " ");
        }
        while (unFixedPointer < n - m) {
            builder.append(unFixed[unFixedPointer++] + " ");
        }
        System.out.println(builder.toString().trim());

        scanner.close();
    }
}
