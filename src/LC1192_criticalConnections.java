import java.util.*;

public class LC1192_criticalConnections {
    /**
     * 规律：
     * 所有在环上的边都不是 critical connection
     * 所有不在环上的边都是 critical connection
     * <p>
     * 解题思路：
     * - 把环找出来，忽略掉环上的边，剩下的就是critical connection
     * - 忽略掉环上的边可以理解为把整个环合并成一个大点
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // 构建一个map，存放每个节点的相邻节点有哪些
        Map<Integer, Set<Integer>> map = new HashMap<>();
        buildMap(connections, map);

        // 创建一个数组，存放每个节点的ID是什么
        int[] id = new int[n];
        Arrays.fill(id, -1);

        // 选取一个点作为根节点，dfs向下递归，过程中识别哪个是关键边
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, 0, -1, id, map, res);

        return res;
    }

    private int dfs(int node, int nodeID, int parent, int[] id, Map<Integer, Set<Integer>> map, List<List<Integer>> res) {
        id[node] = nodeID;

        Set<Integer> set = map.get(node);
        for (Integer neighbor : set) {
            if (neighbor == parent)
                continue;
            else if (id[neighbor] == -1) {
                id[node] = Math.min(id[node], dfs(neighbor, nodeID + 1, node, id, map, res));
            } else {
                id[node] = Math.min(id[node], id[neighbor]);
            }
        }

        if (id[node] == nodeID && node != 0) {
            res.add(Arrays.asList(parent, node));
        }

        return id[node];
    }

    private void buildMap(List<List<Integer>> connections, Map<Integer, Set<Integer>> map) {
        for (List<Integer> edge : connections) {
            int n1 = edge.get(0);
            int n2 = edge.get(1);

            Set<Integer> n1n = map.getOrDefault(n1, new HashSet<>());
            Set<Integer> n2n = map.getOrDefault(n2, new HashSet<>());

            n1n.add(n2);
            n2n.add(n1);

            map.put(n1, n1n);
            map.put(n2, n2n);
        }
    }
}
