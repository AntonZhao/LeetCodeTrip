public class QuickSort {

    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    /**
     * 以当前数组最后一个为锚点，把大于他的放他后面，小于他的放他前面
     * 返回最终的位置
     */
    private int partition(int[] nums, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                // 找到比锚点小的数字，counter右移
                swap(nums, i, counter);
                counter++;
            }
        }
        swap(nums, pivot, counter);
        return counter;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nn = new int[]{12,1,234,121,4,43,6,7,5,5,65,3,5,32,52,3134,674,75,634,63,5,36,3};
        QuickSort sort = new QuickSort();
        sort.sort(nn);
        for (int n : nn) {
            System.out.print(n + " ");
        }
    }
}
