import java.util.ArrayList;
import java.util.List;

public class LC133_cloneGraph {
    NODE[] visited = new NODE[101];

    public NODE cloneGraph(NODE node) {
        int size = node.neighbors.size();

        NODE newNode = new NODE(node.val);
        visited[node.val] = newNode;
        for (int i = 0; i < size; i++) {
            NODE nnode = node.neighbors.get(i);
            if (visited[nnode.val] == null) {
                newNode.neighbors.add(cloneGraph(nnode));
            } else {
                newNode.neighbors.add(visited[nnode.val]);
            }
        }

        return newNode;
    }

}

class NODE {
    public int val;
    public List<NODE> neighbors;

    public NODE() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public NODE(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public NODE(int _val, ArrayList<NODE> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}