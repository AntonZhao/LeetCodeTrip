package exam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU_1 {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRU_1(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                boolean result =  size() > capacity;
                if (result) {
                    System.out.print(eldest.getKey() + "是最老的 --- ");
                }
                return result;
            }
        };
    }

    // key是页号，value就当做这页内存的内容吧
    public void put(int key, int value) {
        map.put(key, value);
        for (Integer k : map.keySet()) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRU_1 lru = new LRU_1(4);

        int[] pages = {1, 8, 1, 7, 8, 2, 7, 2, 1, 8, 3, 8, 2, 1, 3, 1, 7, 1, 3, 7};
        for (int page : pages) {
            System.out.print("当前页: " + page + " --- ");
            lru.put(page, page);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.get(0);
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.get(0);
    }
}
