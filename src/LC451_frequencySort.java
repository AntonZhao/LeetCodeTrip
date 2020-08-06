import java.util.*;
import java.util.function.Consumer;

public class LC451_frequencySort {
    public String frequencySort(String s) {
        // 1. 把字符串统计次数，放进map里
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 2. 创建maxheap，因为我们要保证堆顶char次数是最大的。
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> {
            return e2.getValue() - e1.getValue();
        });
        maxHeap.addAll(map.entrySet());

        // 3. 要创建一个stringbuilder（不要创建string，可以自己比较一下）去存储结果。
        StringBuilder builder = new StringBuilder();

        // 4. 弹出堆顶，按照其统计次数，建立循环，加入char到结果中，重复以上步骤。
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
        }

        // 5. 输出结果即可。
        return builder.toString();
    }

    public String frequencySort2(String s) {
        if (s.length() < 3) return s;
        int[][] buckets = new int[128][2];
        for (int i = 0; i < 128; i++) {
            buckets[i][1] = i;
        }
        for (char c : s.toCharArray()) {
            buckets[c][0]++;
        }

        Arrays.sort(buckets, (o1, o2) -> o2[0] - o1[0]);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            int times = buckets[i][0];
            char c = (char) buckets[i][1];
            for (int j = 0; j < times; j++) {
                res.append(c);
            }
        }

        return res.toString();

    }

    public static void main(String[] args) {
        LC451_frequencySort ll = new LC451_frequencySort();
        System.out.println(ll.frequencySort("tree"));
        System.out.println(ll.frequencySort("Aabb"));
        System.out.println(ll.frequencySort("Aansknglsngnelkgbb"));
        System.out.println(ll.frequencySort2("Aansknglsngnelkgbb"));
    }
}
