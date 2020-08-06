public class LC547_findCircleNum {
    /**
     * https://leetcode-cn.com/problems/friend-circles/solution/union-find-suan-fa-xiang-jie-by-labuladong/
     */
    // 1. 并查集
    public int findCircleNum(int[][] M) {
        int n = M.length;
        Union_Find uf = new Union_Find(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count();
    }

    class Union_Find {
        // 记录连通分量
        private int count;
        // 节点 x 的节点是 parent[x]
        private int[] parent;
        // 记录数的"重量"
        private int[] size;

        /* 构造函数，n 为图的节点总数 */
        public Union_Find(int n) {
            // 一开始互不连通
            this.count = n;
            // 父节点指针初始指向自己
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 将两棵树合并为一棵
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        // 两个节点是否相连
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        // 返回某个节点 x 的根节点
        private int find(int x) {
            // 根节点是指向自己的
            while (parent[x] != x) {
                // 进行路径压缩 牛逼
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // 返回连通分量个数
        public int count() {
            return count;
        }
    }

    // 2. DFS
    public int findCircleNum_dfs(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, boolean[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(m, visited, j);
            }
        }
    }


}
