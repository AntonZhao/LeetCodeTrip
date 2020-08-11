import java.util.HashSet;
import java.util.Set;

public class LC128_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max_length = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer num : set) {
            if (visited.contains(num)) continue;
            visited.add(num);
            int temp_length = 1;
            int left = num - 1;
            int right = num + 1;
            while (set.contains(left) || set.contains(right)) {
                if (set.contains(left)) {
                    visited.add(left);
                    left--;
                    temp_length++;
                }
                if (set.contains(right)) {
                    visited.add(right);
                    right++;
                    temp_length++;
                }
            }
            for (int i = left + 1; i < right; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            max_length = Math.max(max_length, temp_length);
        }
        return max_length;
    }

    public static void main(String[] args) {
        LC128_longestConsecutive ll = new LC128_longestConsecutive();

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(ll.longestConsecutive(nums));
    }
}
