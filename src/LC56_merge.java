import java.util.*;

public class LC56_merge {
    /**
     * leetcode-56 合并区间【中等】
     * 思路：先按照第一位进行排序，然后再进行合并。
     * 优秀题解：
     */
    public int[][] merge(int[][] intervals) {
        // 先声明存储结果的变量，命名为merged
        LinkedList<int[]> merged = new LinkedList<>();
        // 判断 intervals 是否合法
        if (intervals == null || intervals.length == 0) {
            return merged.toArray(new int[0][]);
        }
        // 对 intervals 按照数组的第一位进行排序，自己定义比较器
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        /**
         *  排序完成后对数组进行合并
         *  合并规则是:
         *      当前 merged 最后一个数组的最右小于当前 intervals 数组的最左，则将当前数组添加
         *      否则的话，也就是不加整个数组，只修改一个数字，更新下当前区间的范围，那就挑个大的{merged的最右， 当前数组的最右 }
         *      如果当前merged是空的，直接进行添加
         */
        for (int i = 0; i < intervals.length; i++) {
            if (merged.size() == 0 || merged.getLast()[1] < intervals[i][0]) {
                merged.add(intervals[i]);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
            }
        }
        return merged.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        LC56_merge ll = new LC56_merge();
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] ints : ll.merge(input)) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
