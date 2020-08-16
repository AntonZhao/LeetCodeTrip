import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JZ40_getLeastNumbers {
    /**
     * 维护一个小顶堆 O(N * LogN)
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) return res;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);

        for (int num : arr) {
            heap.add(num);
        }

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    /**
     * 快排的方式 O(N)
     */

    public int[] getLeastNumbers_quickSort(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];

        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    int[] quickSort(int[] arr, int begin, int end, int k) {
        // 每快排切分1次，找到排序后下标为pivot的元素，如果pivot恰好等于k就返回pivot以及pivot左边所有的数；
        int pivot = partition(arr, begin, end);
        // 否则根据下标pivot与k的大小关系来决定继续切分左段还是右段。
        if (pivot == k)
            return Arrays.copyOf(arr, pivot + 1);
        if (pivot < k)
            return quickSort(arr, pivot + 1, end, k);
        if (pivot > k)
            return quickSort(arr, begin, pivot - 1, k);

        return new int[0];
    }

    int partition(int[] nums, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, counter);
                counter++;
            }
        }
        swap(nums, pivot, counter);
        return counter;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
