package exam;

import java.util.Scanner;

public class 马走日 {
    private static int[][] next = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1},
            {-2, 1}, {-2, -1},};
    private static int[][] book;
    private static int[][] map;
    private static int[][] a;//用来记录路径信息
    private static int n, m;
    private static int count = 0;//统计有多少种走法

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        map = new int[n][m];
        book = new int[n][m];
        a = new int[n][m];
        book[x][y] = 1;
        dfs(x, y, 1);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int step) {
        a[x][y] = step;
        if (step == n * m) { // 目标达成
            sop(a);
            count++;
        }
        for (int i = 0; i < next.length; i++) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];
            if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                continue;
            }
            if (book[tx][ty] == 0) {
                book[tx][ty] = 1; // 下一步走这里
                dfs(tx, ty, step + 1);  // 去走吧
                book[tx][ty] = 0; // 走完了是吧，ok，不走这里了
            }
        }

    }

    private static void sop(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
