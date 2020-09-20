public class LC684_findRedundantConnection {
    int[] result = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        int[] father = new int[edges.length + 1];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }

        for (int[] edge : edges) {
            union(father, edge[0], edge[1]);
        }

        return result;
    }

    private void union(int[] father, int u, int v) {
        int uFather = findFather(u, father);
        int vFather = findFather(v, father);
        if (uFather != vFather) {
            father[uFather] = vFather;
        } else {
            result[0] = u;
            result[1] = v;
        }
    }

    private int findFather(int u, int[] father) {
        while (father[u] != u) {
            father[u] = father[father[u]];
            u = father[u];
        }
        return u;
    }

    public static void main(String[] args) {
        LC684_findRedundantConnection ll = new LC684_findRedundantConnection();
        int[] ints = ll.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        System.out.println(ints[0] + " " + ints[1]);
    }


}
