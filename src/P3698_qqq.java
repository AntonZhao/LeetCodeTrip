import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3698_qqq {

    /**
     * 题目信息： https://www.luogu.com.cn/problem/P3698
     */

    static int maxLen;
    static boolean[] visited;
    static List<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int N = sc.nextInt();
        tree = new List[V];
        for (int i = 0; i < V; i++) {
            tree[i] = new ArrayList();
        }
        for (int i = 0; i < V - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        maxLen = 0;
        visited = new boolean[V];

        dfs(0, 1);
        if (N <= maxLen - 1) {
            System.out.println(N + 1);
        } else {
            System.out.println(Math.min(V, maxLen + (N - maxLen + 1) / 2));
        }


    }

    private static void dfs(int position, int depth) {
        visited[position] = true;
        maxLen = Math.max(maxLen, depth);
        for (int i = 0; i < tree[position].size(); i++) {
            Integer curr = tree[position].get(i);
            if (visited[curr])
                continue;
            dfs(curr, depth + 1);
        }
    }
}
