public class LC443_compress {
    /**
     * leetcode-443 压缩字符串【简单】
     * 思路：双指针。保留指针 anchor，指向当前读到连续字符串的起始位置。
     *      从左到右进行读取。当读到最后一个字符，或者下一个下一个字符与当前不同时，则到达连续区块的结尾。
     * 优秀题解：官方
     */
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                // 如果数量大于1个，则需要写入数量
                if (read > anchor) {
                    // 为什么要循环？因为可能数量大于10个，但是每一位只能写一个字符。
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        LC443_compress ll = new LC443_compress();

        char[] chars = {'a','a','a','a','a','a','a','a','a','a','a','a','b','b','b','b','c','c','d','e','e'};
        System.out.println(ll.compress(chars));
    }
}
