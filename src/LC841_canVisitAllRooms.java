import java.util.ArrayList;
import java.util.List;

public class LC841_canVisitAllRooms {

    int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.count = 0;
        boolean[] visited = new boolean[rooms.size()];

        dfs(visited, rooms, 0);

        System.out.println(count);
        return count == rooms.size();
    }

    private void dfs(boolean[] visited, List<List<Integer>> rooms, int curr) {

        visited[curr] = true;
        count++;

        List<Integer> list = rooms.get(curr);
        for (Integer i : list) {
            if (visited[i] == false) {
                dfs(visited, rooms, i);
            }
        }
    }

    public static void main(String[] args) {
        LC841_canVisitAllRooms ll = new LC841_canVisitAllRooms();

        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> t1 = new ArrayList<>();
        t1.add(1);
        ArrayList<Integer> t2 = new ArrayList<>();
        t2.add(2);
        ArrayList<Integer> t3 = new ArrayList<>();
        t3.add(3);
        ArrayList<Integer> t4 = new ArrayList<>();

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        System.out.println(ll.canVisitAllRooms(list));
    }
}
