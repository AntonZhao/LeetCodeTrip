public class LC529_updateBoard {
    int[][] d8 = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        dfs(board, visited, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col) {
        if (!isValid(board, row, col)) return;
        if (visited[row][col]) return;

        visited[row][col] = true;

        int count = 0;
        for (int[] dd : d8) {
            int newRow = row + dd[0];
            int newCol = col + dd[1];
            if (isValid(board, newRow, newCol)) {
                count += board[newRow][newCol] == 'M' ? 1 : 0;
            }
        }


        if (count == 0) {
            board[row][col] = 'B';
            for (int[] dd : d8) {
                int newRow = row + dd[0];
                int newCol = col + dd[1];
                if (isValid(board, newRow, newCol)) {
                    dfs(board, visited, newRow, newCol);
                }
            }
        } else {
            board[row][col] = (char) ('0' + count);
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length) return false;
        return true;
    }

    public static void main(String[] args) {
        LC529_updateBoard ll = new LC529_updateBoard();

        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        char[][] bb = ll.updateBoard(board, new int[]{3, 0});
        for (char[] chars : bb) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
