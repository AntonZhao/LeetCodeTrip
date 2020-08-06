import java.util.TreeMap;

public class LC1122_relativeSortArray {
    /**
     * 根据题意使用计数排序
     * 由于 0 <= arr1[i], arr2[i] <= 1000, 我们使用数组来统计每个元素
     * 然后根据arr2的顺序，填进arr1里，再按照升序继续添加
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num : arr1) count[num]++;

        int i = 0;
        for (int num : arr2) {
            while (count[num]-- > 0) {
                arr1[i++] = num;
            }
        }

        for (int j = 0; j < count.length; j++) {
            while (count[j]-- > 0) {
                arr1[i++] = j;
            }
        }

        return arr1;
    }

    /**
     * Follow-up: What if this constraint 0 <= arr1[i], arr2[i] <= 1000 doesn't exist?
     * Use TreeMap.
     * 用treemap是为了保证keySet的顺序
     */
    public int[] relativeSortArray_noLimit(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
        int i = 0;
        for(int n : arr2) {
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        for(int n : map.keySet()){
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        return arr1;
    }
}
