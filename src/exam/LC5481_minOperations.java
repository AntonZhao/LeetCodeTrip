package exam;

public class LC5481_minOperations {
    public int minOperations(int[] nums) {

        int sumTimes = 0;
        int multiTimes = 0;

        for (int num : nums) {
            if (num == 0) continue;

            int localSum = 0;
            int localMulti = 0;

            while (num != 0) {
                if (num % 2 == 0) {
                    // 是偶数
                    num = num / 2;
                    localMulti += 1;
                } else {
                    // 是奇数
                    num = num - 1;
                    localSum += 1;
                }
            }

            sumTimes += localSum;
            multiTimes = Math.max(multiTimes, localMulti);
        }

        return sumTimes + multiTimes;
    }

    public static void main(String[] args) {
        LC5481_minOperations ll = new LC5481_minOperations();

        System.out.println(ll.minOperations(new int[]{1, 5}));
        System.out.println(ll.minOperations(new int[]{2, 2}));
        System.out.println(ll.minOperations(new int[]{4, 2, 5}));
        System.out.println(ll.minOperations(new int[]{3, 2, 2, 4}));
        System.out.println(ll.minOperations(new int[]{2, 4, 8, 16}));
    }
}
