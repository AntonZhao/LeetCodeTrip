public class LC685_findRedundantDirectedConnection {

    int[] result = new int[2];
    int doubleRoot = 0; //有两个root的节点
    int[] hadRoot; // 每个节点的root数量
    int[][] rootResult = new int[2][2]; // 存放两个root的边

    public int[] findRedundantDirectedConnection(int[][] edges) {
        hadRoot = new int[edges.length + 1];
        int[] father = new int[edges.length + 1];
        // 初始化
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }

        // 统计每个节点的root数量，最后一个有两个root的几点
        for (int[] edge : edges) {
            hadRoot[edge[1]]++;
            if (hadRoot[edge[1]] == 2) {
                doubleRoot = edge[1];
                rootResult[1] = edge;
            } else {
                union(father, edge[1], edge[0]);
            }
        }
        // 如果有两个root的节点
        if (doubleRoot != 0) {
            // 有两个root的两条边：先找到第一条边，刚才已经存了第二条边
            for (int[] edge : edges) {
                if (edge[1] == doubleRoot) {
                    rootResult[0] = edge;
                    break;
                }
            }
            // 这两条边必须删一条
//            int root = 0;
//            for (int i = 1; i < father.length; i++) {
//                if (root == 0) {
//                    root = findXFather(father, i);
//                }
//                if (root != findXFather(father, i)) {
//                    return rootResult[0];
//                }
//            }
//            return rootResult[1];
            if (findXFather(father, rootResult[1][0]) == findXFather(father, doubleRoot))
                return rootResult[1];
            return rootResult[0];
        }
        return result;
    }

    public int findXFather(int[] father, int x) {
        while (father[x] != x) {
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    public void union(int[] father, int x, int y) {
        int xFather = findXFather(father, x);
        int yFather = findXFather(father, y);
        if (xFather != yFather) {
            father[xFather] = yFather;
        } else {
            result[0] = y;
            result[1] = x;
        }
    }

    public static void main(String[] args) {
        LC685_findRedundantDirectedConnection ll = new LC685_findRedundantDirectedConnection();
//        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
//        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}, {4,3}};
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] delete = ll.findRedundantDirectedConnection(edges);
        System.out.println(delete[0] + " " + delete[1]);
    }

}
