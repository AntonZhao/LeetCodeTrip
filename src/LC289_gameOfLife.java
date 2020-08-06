import java.util.Arrays;

public class LC289_gameOfLife {
    /**
     * leetcode-289 生命游戏【中等】
     * 思路：nn的方法就是新建数组进行模拟。
     * n的方法是使用额外的状态，看下方描述。
     * <p>
     * 规则 1：活细胞 周围活细胞 < 2 ==> 死亡。 将细胞值改为 -1，代表这个细胞过去是活的现在死了；
     * <p>
     * 规则 2：活细胞 周围活细胞 == 2 or == 3 ==> 存活。  这时候不改变细胞的值，仍为 1；
     * <p>
     * 规则 3：活细胞 周围活细胞 > 3 ==> 死亡。 同规则1
     * <p>
     * 规则 4：死细胞 周围活细胞 == 3 ==> 复活。 将细胞的值改为 2，代表这个细胞过去是死的现在活了。
     */

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] direct = {{-1, 1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                for (int k = 0; k < direct.length; k++) {
                    int nr = i + direct[k][0], nc = j + direct[k][1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && (board[nr][nc] == 1 || board[nr][nc] == -1)) {
                        count++;
                    }
                }
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = -1;
                    } else {
                        board[i][j] = 1;
                    }
                } else if (board[i][j] == 0) {
                    board[i][j] = count == 3 ? 2 : 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }


    public void gameOfLife_nn(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] res = new int[rows][cols];
        int[][] direct = {{-1, 1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                for (int k = 0; k < direct.length; k++) {
                    int nr = i + direct[k][0], nc = j + direct[k][1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 1) {
                        count++;
                    }
                }
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        res[i][j] = 0;
                    } else {
                        res[i][j] = 1;
                    }
                } else if (board[i][j] == 0) {
                    res[i][j] = count == 3 ? 1 : 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = res[i][j];
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LC289_gameOfLife ll = new LC289_gameOfLife();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        ll.gameOfLife(board);
    }

}
