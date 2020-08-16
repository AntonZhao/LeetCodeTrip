public class LC306_isAdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        return dfs(num, num.length(),0, 0, 0, 0);
    }

    /**
     * @param num 原始字符串
     * @param len 原始字符串长度
     * @param index 当前处理的下标
     * @param sum 前面两个数字之和
     * @param prev 前一个数字
     * @param k 当前是处理的第几个数字
     *
     * 我刚开始疑惑：为什么代码里没有重置 k = 0的操作
     * 其实不用管k的，k只要大于等于2就是可以的
     * 要想看当前数字是不是前两个数字的和，需要记录前两个数字的和 sum
     * 继续往后判断的话，当前数字作为下次判断的前一个数字记录下来， pre
     */
    private boolean dfs(String num, int len, int index, int sum, int prev, int k) {
        if (index == len) return k > 2;

        for (int i = index; i < len; i++) {
            int curr = fetchCurrValue(num, index, i);               // 获取当前数字

            if (curr == -1) continue;                               // 剪枝：开头为0，数字不合法，
            if (k >= 2 && curr != sum) continue;                    // 剪枝：不满足相加条件

            if (dfs(num, len, i + 1, prev + curr, curr, k + 1))     // 当前满足：继续往后判断
                return true;
        }

        return false;
    }

    private int fetchCurrValue(String num, int left, int right) {
        if (left < right && num.charAt(left) == '0')
            return -1;

        int res = num.charAt(left) - '0';
        for (int i = left + 1; i <= right; i++) {
            res = res * 10 + num.charAt(i) - '0';
        }

        return res;
    }

    public static void main(String[] args) {
        LC306_isAdditiveNumber ll = new LC306_isAdditiveNumber();
//        System.out.println(ll.isAdditiveNumber("123"));
        System.out.println(ll.isAdditiveNumber("1235"));
    }

}
