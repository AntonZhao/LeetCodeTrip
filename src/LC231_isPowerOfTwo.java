public class LC231_isPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // n & (n - 1)将最低位1变成0
        return n > 0 && (n & (n - 1)) == 0;
    }
}
