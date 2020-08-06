public class LC130_solve {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 从边上查询
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    // 边上的 O 才可以 连通
                    if (board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return;
        }
        if (board[row][col] == '*' || board[row][col] == 'X') {
            return;
        }

        // 这是连通的记号，还没会替换
        board[row][col] = '*';
        for (int i = 0; i < dx.length; i++) {
            dfs(row + dx[i], col + dy[i], board);
        }
    }
}
