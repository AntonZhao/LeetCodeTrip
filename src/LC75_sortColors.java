public class LC75_sortColors {
    /*
        三指针大法
        若 nums[curr] = 0 ：交换第 curr个 和 第p0个 元素，并将指针都向右移。
        若 nums[curr] = 2 ：交换第 curr个和第 p2个元素，并将 p2指针左移 。
        若 nums[curr] = 1 ：将指针curr右移。
     */
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, curr++, p0++);
            } else if (nums[curr] == 2) {
                swap(nums, curr, p2--);
            } else if (nums[curr] == 1) {
                curr++;
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
