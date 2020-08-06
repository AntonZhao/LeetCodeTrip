import java.util.*;

public class LC210_findOrder {
    /**
     * leetcode-210. 课程表 II 【中等】
     * 图的拓扑排序，DFS和BFS
     * 优秀题解：
     */

    public int[] findOrder_DFS(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return new int[0];
        // 1.建立邻接矩阵
        int[][] graph = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            graph[p[1]][p[0]] = 1;
        }
        // 2. 状态数组，0代表未查看，1代表正在查看，-1代表查完了
        // 为什么用栈存储结果呢？因为DFS会先到最深处，最深处就是最晚学的，在栈底，方便第三步取出
        int[] status = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, status, graph, stack))
                return new int[0];
        }

        // 3. 将栈里数据取出
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean dfs(int i, int[] status, int[][] graph, Stack<Integer> stack) {
        // 如果是1，当前节点正在访问，说明有环；如果是-1，说明访问过了，直接跳过
        if (status[i] == 1) return false;
        if (status[i] == -1) return true;

        // 当前课程尚未访问，设置为1；然后查看当前课程后续课程是否有环
        status[i] = 1;
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == 1 && !dfs(j, status, graph, stack))
                return false;
        }

        // 当前课程后续课程没有环，设置为已访问,再放进栈里
        status[i] = -1;
        stack.push(i);
        return true;
    }

    public int[] findOrder_BFS(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return new int[0];
        // 1. 建立入度表
        int[] inDegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegrees[p[0]]++;
        }
        // 2. 建立队列，入度为0的入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0)
                queue.add(i);
        }

        // 3. 开始学习！注意！入度为0时候才能加到order里面！
        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[count++] = curr;
            for (int[] p : prerequisites) {
                if (p[1] == curr) {
                    if (--inDegrees[p[0]] == 0)
                        queue.add(p[0]);
                }
            }
        }
        if (count == numCourses)
            return order;
        return new int[0];
    }
}
