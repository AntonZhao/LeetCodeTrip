import java.util.Arrays;

public class LC945_minIncrementForUnique {
    // 计数法
    public int minIncrementForUnique_1(int[] A) {
        int[] count = new int[80000];
        for (int n : A) count[n]++;

        int taken = 0, res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                taken += count[i] - 1;
                res -= i * (count[i] - 1);
            } else if (taken > 0 && count[i] == 0) {
                res += i;
                taken--;
            }
        }
        return res;
    }

    //贪心法
    public int minIncrementForUnique_2(int[] A) {
        int len = A.length;
        if (len == 0) return 0;

        Arrays.sort(A);
        int prenum = A[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (A[i] >= prenum + 1) {
                prenum = A[i];
            } else {
                res += (prenum + 1) - A[i];
                prenum++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 1, 7};
        LC945_minIncrementForUnique ll = new LC945_minIncrementForUnique();
        System.out.println(ll.minIncrementForUnique_2(nums));
    }
}
