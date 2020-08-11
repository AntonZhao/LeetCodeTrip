public class LC674_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = 1;
        int currStart = 0; // 当前这段的起始位置，从1开始遍历，那么默认max是1，起始位置currStart是0
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                max = Math.max(max, i - currStart + 1);
            }else {
                currStart = i;
            }
        }
        return max;
    }
}
