public class LC59_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = n - 1;
        int print = 1;

        while (colBegin <= colEnd && rowBegin <= rowEnd) {
            for (int i = colBegin; i <= colEnd; i++) matrix[rowBegin][i] = print++;
            rowBegin++;
            if (rowBegin > rowEnd) break;

            for (int i = rowBegin; i <= rowEnd; i++) matrix[i][colEnd] = print++;
            colEnd--;
            if (colEnd < colBegin) break;

            for (int i = colEnd; i >= colBegin; i--) matrix[rowEnd][i] = print++;
            rowEnd--;
            if (rowEnd < rowBegin) break;

            for (int i = rowEnd; i >= rowBegin; i--) matrix[i][colBegin] = print++;
            colBegin++;
            if (colBegin > colEnd) break;
        }

        return matrix;
    }
}
