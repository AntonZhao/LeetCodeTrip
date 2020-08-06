import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC1103_distributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0;
        while (candies > 0) {
            res[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        LC1103_distributeCandies ll = new LC1103_distributeCandies();
        int[] arr = ll.distributeCandies(7, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

        System.out.println();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        for (Integer i : map.keySet()) {
            System.out.println(i);
        }
        System.out.println();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o1 - o2);
        treeMap.put(1, 1);
        treeMap.put(2, 2);
        treeMap.put(3, 3);
        treeMap.put(4, 4);
        treeMap.entrySet();
        System.out.println(treeMap.firstKey());
    }
}
