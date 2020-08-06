import java.util.LinkedList;
import java.util.Queue;

public class LC542_updateMatrix {
    /**
     * leetcode-542 01矩阵【中等】
     * 思路：考察的是BFS，多起点的BFS
     * 优秀题解：https://leetcode-cn.com/problems/01-matrix/solution/tao-lu-da-jie-mi-gao-dong-ti-mu-kao-cha-shi-yao-2/
     */
    public int[][] updateMatrix(int[][] matrix) {
        // 矩阵的基本信息
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 创建用于BFS的队 | 是否访问的矩阵 | 结果矩阵
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] res = new int[rows][cols];
        // 把所有的0放进队列，也就是多起点，并且把相应的visited标记为被访问过。
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
//                    res[i][j] = 0;
                }
            }
        }
        // 四联通，四个方向
        // 初始步数为0
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        // 开始【要确定当前遍历到了哪一层的BFS】
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point point = queue.poll();
                int curRow = point.row;
                int curCol = point.col;
                if (matrix[curRow][curCol] == 1) {
                    res[curRow][curCol] = step;
                }
                for (int[] direction : directions) {
                    int newRow = curRow + direction[0];
                    int newCol = curCol + direction[1];
                    if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol] == true) {
                        continue;
                    }
                    queue.add(new Point(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
            step++;
        }
        return res;
    }

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        LC542_updateMatrix ll = new LC542_updateMatrix();
//        int[][] matrix = {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] matrix = {{1, 1, 1}, {1, 1, 1}, {1, 1, 0}};
        int[][] res = ll.updateMatrix(matrix);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
