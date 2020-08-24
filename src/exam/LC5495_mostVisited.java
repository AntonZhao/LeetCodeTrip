package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC5495_mostVisited {
    public List<Integer> mostVisited(int n, int[] rounds) {

        int start = rounds[0];
        int end = rounds[rounds.length - 1];

        ArrayList<Integer> res = new ArrayList<>();

        if (start <= end) {
            for (int i = start; i <= end; i++) {
                res.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                res.add(i);
            }
            for (int i = start; i <= n; i++) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC5495_mostVisited ll = new LC5495_mostVisited();

        List<Integer> list = ll.mostVisited(4, new int[]{1, 3, 1, 2});

        System.out.println(list.toString());
    }
}
