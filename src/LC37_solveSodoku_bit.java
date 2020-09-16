import java.util.ArrayList;
import java.util.List;

public class LC37_solveSodoku_bit {

    private int[] line = new int[9];
    private int[] column = new int[9];
    private int[][] block = new int[3][3];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    // flip
                    flip(i, j, digit);
                }
            }
        }
        dfs(board, 0);
    }

    private void flip(int i, int j, int digit) {
        line[i] ^= (1 << digit);
        column[i] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    public static void main(String[] args) {
        LC37_solveSodoku_bit ll = new LC37_solveSodoku_bit();
        char[][] board = {{'.', '.', '3', '.', '.', '.', '.', '.', '6'},
                {'.', '6', '.', '3', '2', '9', '.', '.', '.'},
                {'9', '.', '8', '4', '.', '.', '.', '.', '3'},
                {'.', '1', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '9', '.', '.', '.', '.', '8', '.'},
                {'.', '7', '.', '1', '9', '.', '.', '.', '2'},
                {'.', '.', '.', '.', '.', '5', '7', '.', '.'},
                {'4', '.', '.', '2', '.', '6', '.', '1', '.'},
                {'.', '.', '.', '.', '.', '4', '9', '.', '5'}};

        ll.solveSudoku(board);
    }
}
