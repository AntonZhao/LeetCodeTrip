import java.util.HashMap;
import java.util.Map;

public class LC974_subarraysDivByK {
    /**
     * leetcode-974 和可被 K 整除的子数组【中等】
     * 看到连续子数组就应该想到前缀和
     * 优秀题解：官方题解不错
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        // 初始化hashmap，0代表前缀和为0，也就是啥都没，1就是出现了一次
        record.put(0, 1);
        // 用来统计当前的子数组和
        int sum = 0;
        int res = 0;
        for (int num : A) {
            sum += num;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            // 注意这里求余数要用当前的子数组和
            int mod = (sum % K + K) % K;
            // 找前面一样余数的个数 —— 余数一样才能保证两个数相加被还是被K整除
            int same = record.getOrDefault(mod, 0);
            res += same;
            record.put(mod, same + 1);
        }
        return res;
    }
}
