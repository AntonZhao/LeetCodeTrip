public class JZ03_findRepeatNumber {
    //将数组视为哈希表
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
