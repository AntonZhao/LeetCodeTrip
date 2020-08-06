import java.util.HashMap;
import java.util.Map;

public class LC169_majorityElement {
    // 使用hashmap存储， 复杂度O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxNum = 0, maxCount = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);

            if(count + 1 > maxCount) {
                maxCount = count + 1;
                maxNum = num;
            }
        }
        return maxNum;
    }

    //    摩尔投票法
    public int majorityElement_vote(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    candidate = nums[i];
                }
            }
        }
        return candidate;
    }


}
