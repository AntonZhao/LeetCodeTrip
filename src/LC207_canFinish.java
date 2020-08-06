import java.util.ArrayList;
import java.util.List;

public class LC207_canFinish {

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        return valid;
    }

    /**
     * node = 0 --- 未遍历
     * node = 1 --- 正在遍历
     * node = 2 --- 遍历完成
     * @param curNode
     */

    private void dfs(int curNode) {
        visited[curNode] = 1;

        for (Integer v : edges.get(curNode)) {
            if (visited[v] == 0) {
                dfs(v);
                if (valid == false) return;
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }

        visited[curNode] = 2;
    }

}
