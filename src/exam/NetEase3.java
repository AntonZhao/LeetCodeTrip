package exam;

import java.util.Scanner;

public class NetEase3 {

    public static int maxValue = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] s = line.trim().split(" ");
        int N = Integer.valueOf(s[0]);
        int K = Integer.valueOf(s[1]);
        int M = Integer.valueOf(s[2]);

        int[][] matrix = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                matrix[i][j] = maxValue;
            }
        }
        for (int i = 0; i < M; i++) {
            String input = sc.nextLine();
            String[] strings = input.trim().split(" ");
            Integer from = Integer.valueOf(strings[0]);
            Integer to = Integer.valueOf(strings[1]);
            Integer time = Integer.valueOf(strings[2]);
            matrix[from][to] = time;
        }

        int[] distance = new int[N + 1];
        // 从k出发
        distance[K] = 0;
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;
        for (int i = 1; i <= N - 1; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 1; j <= N; j++) {
                if (visited[j] == false && matrix[K][j] < min) {
                    min = matrix[K][j];
                    index = j;
                }
            }
            distance[index] = min;
            visited[index] = true;
            for (int j = 1; j <= N; j++) {
                if (visited[j] == false && matrix[K][index] + matrix[index][j] < matrix[K][j]) {
                    matrix[K][j] = matrix[K][index] + matrix[index][j];
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == maxValue) {
                maxDistance = -1;
                break;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }
        System.out.println(maxDistance);

        sc.close();
    }
}
