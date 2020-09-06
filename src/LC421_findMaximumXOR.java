import java.util.HashSet;

public class LC421_findMaximumXOR {
    /**
     * 先确定高位，再确定低位（有点贪心算法的意思），才能保证这道题的最大性质
     * 一位接着一位去确定这个数位的大小
     * 利用性质： a ^ b = c ，则 a ^ c = b，且 b ^ c = a
     */
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            // 注意点1：注意保留前缀的方法，mask 是这样得来的
            // 用异或也是可以的 mask = mask ^ (1 << i);
            mask = mask | (1 << i);
//            System.out.println(Integer.toBinaryString(mask));
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            // if p1 ^ temp = p2 then
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC421_findMaximumXOR ll = new LC421_findMaximumXOR();

        System.out.println(ll.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

}
