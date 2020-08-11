public class LC130_solve {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        // 这道题就是从边界上的O出发，dfs寻找相连的O
        // 为了防止重复，把连接到的换个字母表示
        if (board == null || board.length < 3) return;

        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (board[row][col] != 'O') return;

        board[row][col] = 'A';
        for (int i = 0; i < 4; i++) {
            dfs(board, row + dx[i], col + dy[i]);
        }
    }
}
