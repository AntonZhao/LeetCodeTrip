import java.util.ArrayList;
import java.util.List;

public class LC54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int rowEnd = matrix.length - 1, rowBegin = 0;
        int colEnd = matrix[0].length - 1, colBegin = 0;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            if (rowBegin > rowEnd) break;

            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (colEnd < colBegin) break;

            for (int i = colEnd; i >= colBegin; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            if (rowEnd < rowBegin) break;

            for (int i = rowEnd; i >= rowBegin; i--) {
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
            if (colBegin > colEnd) break;
        }


        return res;
    }

    public static void main(String[] args) {
        LC54_spiralOrder ll = new LC54_spiralOrder();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix2 = new int[][]{{1}, {5}, {9}};
        int[][] matrix3 = new int[][]{{1}, {5}, {9}};
        System.out.println(ll.spiralOrder(matrix));
        System.out.println(ll.spiralOrder(matrix2));
    }
}
