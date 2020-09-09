import java.util.*;

public class LC347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() == k) {
                if (entry.getValue() > priorityQueue.peek().getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(entry);
                }
            } else {
                priorityQueue.add(entry);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll().getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        LC347_topKFrequent ll = new LC347_topKFrequent();
//        int[] res = ll.topKFrequent(new int[]{1, 1, 1, 2, 3, 2}, 2);
        int[] res = ll.topKFrequent(new int[]{-1, -1}, 1);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
    }
}
