public class LC48_rotate {
    /**
     * 先对称反转，再每行反转
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        print(matrix);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    /**
     * 依次反转四个角
     */
    public void rotate_4(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                // 右下的值移到左下
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                // 右上的值移到右下
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                // 左上的值移到右上
                matrix[j][n - 1 - i] = matrix[i][j];
                // 左下的值移到左上
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        LC48_rotate ll = new LC48_rotate();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ll.rotate(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=====================");
    }
}
