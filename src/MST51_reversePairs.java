public class MST51_reversePairs {
    /**
     * leetcode-面试题51 数组中的逆序对【困难】
     * 利用归并排序分成两部分有序数组的机制，可以统计逆序对
     * 优秀题解：
     */

    int res = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[end - start + 1];

        while (i <= mid || j <= end) {
            if (i == mid + 1) {
                temp[k++] = nums[j++];
                continue;
            }
            if (j == end + 1) {
                temp[k++] = nums[i++];
                continue;
            }
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                res += mid - i + 1;
            }
        }

        for (int l = 0; l < end - start + 1; l++) {
            nums[start + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        MST51_reversePairs ll = new MST51_reversePairs();
//        int[] nums = {7, 5, 6, 4};
        int[] nums = {1, 2, 3, 4, 5, 4};
        System.out.println(ll.reversePairs(nums));

    }

    /**
     * 垃圾方法
     */

    public int reversePairs_nn(int[] nums) {
        int res = 0;
        int len = nums.length;
        if (len <= 1) return 0;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) res++;
            }
        }

        return res;
    }
}
