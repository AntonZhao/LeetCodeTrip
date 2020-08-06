public class MST0107_rotate {
    /**
     * 面试题0107-旋转矩阵【中等】
     * 思路：先上下翻转，再主对角线翻转
     * 时间复杂度：O(N^2)
     * 题解：
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
            int row1 = i, row2 = N - 1 - i;
            for (int j = 0; j < N; j++) {
                int temp = matrix[row1][j];
                matrix[row1][j] = matrix[row2][j];
                matrix[row2][j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        MST0107_rotate ll = new MST0107_rotate();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        print(matrix);
        ll.rotate(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
