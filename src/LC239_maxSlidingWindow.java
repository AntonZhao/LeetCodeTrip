import java.util.LinkedList;
public class LC239_maxSlidingWindow {
    public static int[] maxSlidingWindow_deque(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return nums;
        int[] res = new int[nums.length - k + 1];
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow_nn(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return nums;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(nums[i + j], max);
            }
            res[i] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow_deque(nums, 3));
    }
}
