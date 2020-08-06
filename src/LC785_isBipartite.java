import java.util.LinkedList;
import java.util.Queue;

public class LC785_isBipartite {
    public boolean isBipartite_bfs(int[][] graph) {
        // 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 bfs 染色。
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            // 每出队一个顶点，将其所有邻接点染成相反的颜色并入队。
            visited[i] = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int node : graph[cur]) {
                    // 如果当前顶点的某个邻接点已经被染过色了，且颜色和当前顶点相同，说明此无向图无法被正确染色，返回 false。
                    if (visited[node] == visited[i]) {
                        return false;
                    }
                    if (visited[node] == 0) {
                        visited[node] = -visited[cur];
                        queue.offer(node);
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartite_dfs(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(graph, i , 1, visited)) {
                return false;
            }
        }
        return true;
    }
    // 去给v点染色，并把v周边的染成和v不一样的颜色
    // 如果节点和要染的颜色一样，那就不对了
    private boolean dfs(int[][] graph, int v, int color, int[] visited) {
        if (visited[v] != 0) {
            return visited[v] == color;
        }
        visited[v] = color;
        for (int node : graph[v]) {
            if (!dfs(graph, node, -color, visited)) {
                return false;
            }
        }
        return true;
    }


}
