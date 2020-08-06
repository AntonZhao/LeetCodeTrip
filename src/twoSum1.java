import java.util.HashMap;

public class twoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (m.containsKey(temp) && m.get(temp) != i) {
                res[1] = m.get(temp);
                res[0] = i;
                break;
            }
            m.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] r = twoSum(nums, 9);
        System.out.println(r[0] + " " + r[1]);
    }
}
