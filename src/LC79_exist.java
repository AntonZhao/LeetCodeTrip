public class LC79_exist {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int depth, char[][] board, String word) {
        if (depth == word.length())
            return true;
        if (row < 0 || row == board.length || col < 0 || col == board[0].length)
            return false;
        if (board[row][col] != word.charAt(depth))
            return false;

        board[row][col] = '*';
        boolean exist = dfs(row + 1, col, depth + 1, board, word)
                || dfs(row - 1, col, depth + 1, board, word)
                || dfs(row, col + 1, depth + 1, board, word)
                || dfs(row, col - 1, depth + 1, board, word);
        board[row][col] = word.charAt(depth);
        return exist;
    }

    public static void main(String[] args) {
        LC79_exist ll = new LC79_exist();
        char[][] board = {{'a'}};
        System.out.println(ll.exist(board, "a"));
    }


}
