public class solveSudoku37 {
    //每行几个九宫格
    int n = 3;
    //行数
    int N = n * n;

    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    private void backtrack(int row, int col) {
        /*
        开始回溯
         */
        //如果这个格子是空的
        if (board[row][col] == '.') {
            // 1-9挨个往里放
            for (int d = 1; d <= 9; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    if (!sudokuSolved) removeNumber(d, col, row);
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    private void removeNumber(int d, int col, int row) {
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    private void placeNextNumbers(int row, int col) {
        //如果当前是最后一个格子，说明有解
        if (row == N - 1 && col == N - 1) {
            sudokuSolved = true;
        } else {
            //如果在 当前行 的末尾， 就去下一行
            if (col == N - 1) backtrack(row + 1, 0);
            else backtrack(row, col + 1);
        }
    }

    private boolean couldPlace(int d, int row, int col) {
        //检查当前格子能否防止d数字
        int box_index = (row / n) * n + col / n;

        return rows[row][d] + columns[col][d] + boxes[box_index][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
        int box_index = (row / n) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[box_index][d]++;
        board[row][col] = (char) (d + '0');
    }

    public static void main(String[] args) {
        solveSudoku37 solution = new solveSudoku37();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        printSudoku(board);

        solution.solveSudoku(board);

        printSudoku(board);
    }

    private static void printSudoku(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

}
