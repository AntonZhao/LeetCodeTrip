package exam;

import java.util.Arrays;
import java.util.HashMap;

public class LC5497_findLatestStep {

    /**
     * 精华：更新长度只需要考虑边界！！！！！
     *
     * iToLen: 存储下标对应长度
     * lenToCount: 对应长度的计数
     */
    public int findLatestStep(int[] arr, int m) {
        int[] iToLen = new int[arr.length];
        int[] lenToCount = new int[arr.length + 1];
        int res = -1;
        Arrays.fill(iToLen, -1);

        for (int i = 0; i < arr.length; i++) {
            // 下标改成适合数组的
            int index = arr[i] - 1;
            // 左边的连续1数量 和 右边的连续1数量
            int left = 0;
            int right = 0;
            // 算上当前位置，整个连续1的 开始 和 结束
            int start = index;
            int end = index;
            // 如果左边位置合法，左边肯定是个边界，更新 start 和 left
            if (index - 1 >= 0 && iToLen[index - 1] != -1) {
                start -= iToLen[index - 1];
                left = iToLen[index - 1];
            }
            // 如果右边位置合法，右边肯定是个边界，更新 endt 和 right
            if (index + 1 < arr.length && iToLen[index + 1] != -1) {
                end += iToLen[index + 1];
                right = iToLen[index + 1];
            }
            // 算上左右的新连续1串长度，且更新首尾
            // 当左边不合法或者没1的时候，当前位置就是start
            // 当右边不合法或者没1的时候，当前位置就是end
            int newLen = left + right + 1;
            iToLen[start] = newLen;
            iToLen[end] = newLen;
            // 对应长度修改下~为0表示没有子串
            lenToCount[left] -= left;
            lenToCount[right] -= right;
            lenToCount[newLen] += newLen;
            // 不为0的话，更新结果
            if (lenToCount[m] > 0) {
                res = i + 1;
            }
        }
        return res;
    }

    public int findLatestStep_timeSoLong(int[] arr, int m) {

        int[] lengths = new int[arr.length];

        int res = -1;

        for (int i = 0; i < arr.length; i++) {

            int index = arr[i] - 1;
            lengths[index] = 1;

            int left = index - 1 >= 0 ? lengths[index - 1] : 0;
            int right = (index + 1 < arr.length) ? lengths[index + 1] : 0;

            lengths[index] += left + right;

            int leftIndex = index - 1;
            while (leftIndex >= 0 && lengths[leftIndex] != 0) lengths[leftIndex--] = lengths[index];
            int rightIndex = index + 1;
            while (rightIndex < arr.length && lengths[rightIndex] != 0) lengths[rightIndex++] = lengths[index];

            for (int length : lengths) {
                System.out.print(length + " ");
            }
            System.out.println();

            for (int length : lengths) {
                if (length == m) {
                    res = i + 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC5497_findLatestStep ll = new LC5497_findLatestStep();

        int[] nums = new int[]{3, 5, 1, 2, 4};
        System.out.println(ll.findLatestStep(nums, 1));
    }
}
