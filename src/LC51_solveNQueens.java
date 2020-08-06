import java.util.*;

public class LC51_solveNQueens {
    /**
     * col:列状态-->每列不能有重复的
     * master：主对角线状态-->横纵坐标之差固定
     * slave：副对角线状态-->横纵坐标之和固定
     */
    private Set<Integer> col;
    private Set<Integer> master;
    private Set<Integer> slave;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        col = new HashSet<>();
        master = new HashSet<>();
        slave = new HashSet<>();

        Stack<Integer> stack = new Stack<>(); //用来存放每个棋子的列，栈顶是最后一行
        backtrack(0, stack);
        return res;
    }

    private void backtrack(int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                stack.add(i);
                col.add(i);
                master.add(row + i);
                slave.add(row - i);

                backtrack(row + 1, stack);

                slave.remove(row - i);
                master.remove(row + i);
                col.remove(i);
                stack.pop();
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            sb.replace(num, num + 1, "Q");
            board.add(sb.toString());
        }
        return board;
    }

    /**
     * 位图、位运算技巧
     * 避免了哈希表或者数组的使用，进一步压缩空间
     * x ^ (1 << i) 将x的第i位取反
     */
    public List<List<String>> solveNQueens_bits(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) return res;

        int col = 0, master = 0, slave = 0;
        Stack<Integer> stack = new Stack<>();
        backtrack_bits(0, col, master, slave, stack);
        return res;
    }

    private void backtrack_bits(int row, int col, int master, int slave, Stack<Integer> stack) {
        if (row == n) {
            res.add(convert2board(stack, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0
                    && ((master >> (row + i)) & 1) == 0
                    && ((slave >> (row - i + n - 1)) & 1) == 0) {
                stack.push(i);
                col ^= (1 << i);
                master ^= (1 << row + i);
                slave ^= (1 << row - i + n - 1); //因为 row - i 可能为负数

                backtrack_bits(row + 1, col, master, slave, stack);

                stack.pop();
                col ^= (1 << i);
                master ^= (1 << row + i);
                slave ^= (1 << row - i + n - 1);
            }
        }
    }


    public static void main(String[] args) {
        LC51_solveNQueens ll = new LC51_solveNQueens();
        List<List<String>> lists = ll.solveNQueens(14);
//        for (List<String> l : lists) {
//            for (String s : l) {
//                System.out.println(s);
//            }
//            System.out.println();
//        }
        System.out.println(lists.size());
    }
}
