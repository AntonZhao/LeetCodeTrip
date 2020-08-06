public class LC240_searchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;

        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            }
            if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
