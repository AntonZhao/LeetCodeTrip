import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1380_luckyNumbers {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] rowMin = new int[rows];
        int[] colMax = new int[cols];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == rowMin[i] && rowMin[i] == colMax[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1380_luckyNumbers ll = new LC1380_luckyNumbers();
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(ll.luckyNumbers(matrix));
    }
}
