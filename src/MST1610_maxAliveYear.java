public class MST1610_maxAliveYear {
    /**
     * 本题和 20200801的猿辅导java笔试第一题很像
     * 都是重叠区间，一个求个数，一个求index
     * 方法就是统计每年的增加人数，可能是正可能是负的，统计一遍就可以
     * 复杂度取决于题目，O(N)吧
     */
    public int maxAliveYear(int[] birth, int[] death) {
        int[] count = new int[102];
        for (int i = 0; i < birth.length; i++) {
            count[birth[i] - 1900] += 1;
            count[death[i] - 1899] -= 1;
        }
        int maxIndex = 0;
        int maxCount = 0;
        for (int i = 1; i < 102; i++) {
            count[i] = count[i] + count[i - 1];
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxIndex = i;
            }
        }

        return maxIndex + 1900;
    }
}
