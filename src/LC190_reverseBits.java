public class LC190_reverseBits {
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>>= 1;
            System.out.print("res = " + Integer.toBinaryString(res) + " n = " + Integer.toBinaryString(n));
            if (i < 31) {
                res <<= 1;
            }
            System.out.println(" res = " + Integer.toBinaryString(res));
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 1 + 2 + 4 + 8 + 16 + 32 + 64 + 128 + 256 + 512 + 1024;
        int n2 = -3;
        System.out.println(Integer.toBinaryString(n2));
        System.out.println(reverseBits(n2));
    }
}
