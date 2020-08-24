public class LC201_rangeBitwiseAnd {
    /**
     * 求 m 和 n 的公共前缀
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            count++;
        }
        return 1 << count;
    }
}
