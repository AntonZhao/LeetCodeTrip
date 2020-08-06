public class LC200_numIslands {
    // 1. DFS
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null) return res;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }

    // 2. 并查集
    public int numIslands_uf(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        Union_Find uf = new Union_Find(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') { // 往下
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') { // 往上
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') { // 往左
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') { // 往右
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }

    class Union_Find {
        // 记录连通分量
        private int count;
        // 节点 x 的节点是 parent[x]
        private int[] parent;
        // 记录数的"重量"
        private int[] size;

        /* 构造函数，n 为图的节点总数 */
        public Union_Find(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            count = 0;
            parent = new int[m * n];
            size = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j; //初始状态为指向自己
                        count++;
                    }
                    size[i * n + j] = 1;
                }
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
        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}};
        System.out.println(new LC200_numIslands().numIslands(grid));
    }
}
