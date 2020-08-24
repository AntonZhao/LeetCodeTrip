package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC5480_findSmallestSetOfVertices {
    /**
     * 求入度为0的点集合
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> edge : edges) {
            map.put(edge.get(1), map.getOrDefault(edge.get(1), 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i))
                res.add(i);
        }
        return res;
    }
}
