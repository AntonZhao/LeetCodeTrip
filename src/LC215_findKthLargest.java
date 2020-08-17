import java.util.Arrays;

public class LC215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int begin, int end, int k) {
        int pivot = partition(nums, begin, end);
        if (pivot == k)
            return nums[pivot];
        if (pivot > k)
            return quickSort(nums, begin, pivot - 1, k);
        if (pivot < k)
            return quickSort(nums, pivot + 1, end, k);
        return 0;
    }

    private int partition(int[] nums, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, counter, i);
                counter++;
            }
        }
        swap(nums, pivot, counter);
        return counter;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC215_findKthLargest ll = new LC215_findKthLargest();

//        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(ll.findKthLargest(nums, k));
    }


}
