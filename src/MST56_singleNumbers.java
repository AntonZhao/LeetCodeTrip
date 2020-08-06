public class MST56_singleNumbers {
    /**
     * leetcode-面试题56 数组中数字出现的次数 【中等】
     * 最好的办法是使用位运算，异或
     * 优秀题解：
     */
    public int[] singleNumbers(int[] nums) {
        // 1. 将所有数字异或
        // 一样的消掉，最后的结果是两个不一样数字的异或值
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }

        // 2. 找到lowbit，就是最低位的1，用这个1对数组进行分组，
        // 分组依据就是这两个只出现一次的数字在这一位上不同
        int lowbit = xor & (-xor);
        // 3. 再对数组遍历一遍，分别对res[0] 和 res[1] 进行异或
        // 为啥可以直接进行异或呢？因为那些出现两次的数字也会直接消掉
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }


    public int[] singleNumbers_laji(int[] nums) {
        int[] res = new int[2];
        int[] nn = new int[10001];
        for (int num : nums) {
            nn[num] += 1;
        }
        for (int i = 0; i < nn.length; i++) {
            if (nn[i] == 1 && res[0] == 0) {
                res[0] = i;
                continue;
            }
            if (nn[i] == 1 && res[1] == 0) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int xor = 4 ^ 6;
        System.out.println(xor);
        int mask = xor & (-xor);
        System.out.println(mask);
    }
}
