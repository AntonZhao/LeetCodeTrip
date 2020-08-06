import java.util.*;

public class LC365_canMeasureWater {
    // GCD做法
    public boolean canMeasureWater_GCD(int x, int y, int z) {
        if (z == 0) return true;
        if (x + y < z) return false;

        int big = Math.max(x, y);
        int small = x + y - big;

        if (small == 0) return big == z;


        while (big % small != 0) {
            int temp = small;
            small = big % small;
            big = temp;
        }
        return z % small == 0;
    }

    //极简BFS
    //https://leetcode.com/problems/water-and-jug-problem/discuss/83716/Java-Programmatic-Solution-BFS-without-GCD
    public boolean canMeasureWater_BFS(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n + x <= x + y && set.add(n + x)) {
                q.offer(n + x);
            }
            if (n + y <= x + y && set.add(n + y)) {
                q.offer(n + y);
            }
            if (n - x >= 0 && set.add(n - x)) {
                q.offer(n - x);
            }
            if (n - y >= 0 && set.add(n - y)) {
                q.offer(n - y);
            }
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }

    //朴素BFS
    public boolean canMeasureWater(int x, int y, int z) {
        // 特判
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }

        State initState = new State(0, 0);

        // 广度优先遍历使用队列
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        queue.offer(initState);
        visited.add(initState);

        while (!queue.isEmpty()) {
            State head = queue.poll();

            int curX = head.getX();
            int curY = head.getY();

            // curX + curY == z 比较容易忽略
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }

            // 从当前状态获得可能的下一步的状态
            List<State> nextStates = getNextStates(curX, curY, x, y);
            // 调试代码
            // System.out.println(head + " => " + nextStates);
            for (State nextState : nextStates) {
                if (!visited.contains(nextState)) {
                    queue.offer(nextState);
                    visited.add(nextState);
                }
            }
        }
        return false;
    }

    private List<State> getNextStates(int curX, int curY, int x, int y) {
        List<State> nextStates = new ArrayList<>(8);

        // 以下两个状态，对应操作 1

        // 外部加水，使得 A 满
        State nextState1 = new State(x, curY);
        // 外部加水，使得 B 满
        State nextState2 = new State(curX, y);

        // 以下两个状态，对应操作 2

        // 把 A 清空
        State nextState3 = new State(0, curY);
        // 把 B 清空
        State nextState4 = new State(curX, 0);

        // 以下两个状态，对应操作 3

        // 从 A 到 B，使得 B 满，A 还有剩
        State nextState5 = new State(curX - (y - curY), y);
        // 从 A 到 B，此时 A 的水太少，A 倒尽，B 没有满
        State nextState6 = new State(0, curX);

        // 从 B 到 A，使得 A 满，B 还有剩余
        State nextState7 = new State(x, curY - (x - curX));
        // 从 B 到 A，此时 B 的水太少，B 倒尽，A 没有满
        State nextState8 = new State(curY, 0);

        // 以下判断是一些简单的剪枝操作，不难，但是有点烦

        if (curX < x) {
            nextStates.add(nextState1);
        }

        if (curY < y) {
            nextStates.add(nextState2);
        }

        nextStates.add(nextState3);
        nextStates.add(nextState4);

        if (curX - (y - curY) > 0) {
            nextStates.add(nextState5);
        }

        if (curY - (x - curX) > 0) {
            nextStates.add(nextState7);
        }

        if (curY == 0 && y > curX) {
            nextStates.add(nextState6);
        }

        if (curX == 0 && x > curY) {
            nextStates.add(nextState8);
        }
        return nextStates;
    }

    private class State {
        private int x;
        private int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) {
        LC365_canMeasureWater solution = new LC365_canMeasureWater();

        int x = 3;
        int y = 5;
        int z = 4;

//        int x = 2;
//        int y = 6;
//        int z = 5;

//        int x = 1;
//        int y = 2;
//        int z = 3;
        boolean res = solution.canMeasureWater(x, y, z);
        System.out.println(res);
    }

}
