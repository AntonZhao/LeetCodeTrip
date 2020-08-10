import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
    private Integer capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRU(Integer capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldset) {
                return size() > capacity;
            }
        };
    }

    public Integer get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

}
