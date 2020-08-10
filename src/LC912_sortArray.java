import java.util.Arrays;

public class LC912_sortArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
//        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) return;

        int mid = (begin + end) >> 1;
        mergeSort(nums, begin, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, begin, mid, end);
    }

    private void merge(int[] nums, int begin, int mid, int end) {
        int i = begin, j = mid + 1;
        int[] mergeArr = new int[end - begin + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                mergeArr[k++] = nums[i++];
            } else {
                mergeArr[k++] = nums[j++];
            }
        }
        while (i <= mid) mergeArr[k++] = nums[i++];
        while (j <= end) mergeArr[k++] = nums[j++];
        for (int l = 0; l < mergeArr.length; l++) {
            nums[begin + l] = mergeArr[l];
        }
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, counter);
                counter++;
            }
        }
        swap(nums, counter, pivot);
        return counter;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC912_sortArray ll = new LC912_sortArray();
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
//        System.out.println(ll.partition(nums, 0, nums.length - 1));
        ll.sortArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
