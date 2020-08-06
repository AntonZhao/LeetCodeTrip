public class LC37_solveSodoku {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) { //trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) return true;

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC37_solveSodoku ll = new LC37_solveSodoku();
        char[][] board =   {{'.', '.', '3', '.', '.', '.', '.', '.', '6'},
                            {'.', '6', '.', '3', '2', '9', '.', '.', '.'},
                            {'9', '.', '8', '4', '.', '.', '.', '.', '3'},
                            {'.', '1', '.', '.', '.', '3', '.', '.', '.'},
                            {'.', '.', '9', '.', '.', '.', '.', '8', '.'},
                            {'.', '7', '.', '1', '9', '.', '.', '.', '2'},
                            {'.', '.', '.', '.', '.', '5', '7', '.', '.'},
                            {'4', '.', '.', '2', '.', '6', '.', '1', '.'},
                            {'.', '.', '.', '.', '.', '4', '9', '.', '5'}};
        ll.solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
