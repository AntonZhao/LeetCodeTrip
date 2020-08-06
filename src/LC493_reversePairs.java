public class LC493_reversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) >> 1;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        int[] cache = new int[right - left + 1];
        /**
         * i 和 t 都是左半部分的指针，i 用来找翻转对， t 用来执行合并操作
         * 为什么是 count += mid - i + 1; 呢？
         * 因为左半部分已经排好序了，且当前循环右边数字是确定的，只要找到左边的边界数字，剩下的都是符合条件的，太强了
         *
         *
         * 由于外面是右半部分的循环，所以循环外只需要看左边有没有找完。
         */
        int i = left, t = left, c = 0;
        for (int j = mid + 1; j <= right; j++, c++) {
            while (i <= mid && nums[i] <= 2 * (long) nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache, 0, nums, left, right - left + 1);
        return count;
    }

    public static void main(String[] args) {
        LC493_reversePairs ll = new LC493_reversePairs();
//        int[] nums = {1, 3, 2, 3, 1};
        int[] nums = {2, 4, 3, 5, 1};
        System.out.println(ll.reversePairs(nums));
    }

}
