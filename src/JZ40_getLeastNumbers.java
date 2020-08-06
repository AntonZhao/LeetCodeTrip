import java.util.PriorityQueue;

public class JZ40_getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) return res;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int num : arr) {
            heap.add(num);
        }

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        JZ40_getLeastNumbers jj = new JZ40_getLeastNumbers();
        int[] arr = {0, 1, 2, 1};
        int[] res = jj.getLeastNumbers(arr, 2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
