package exam;

import java.util.HashSet;

public class XHS2 {

    static int findMin(int[][] arr) {
        int len = arr.length * arr[0].length;
        int res = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int[] nums : arr) {
            for (int num : nums) {
                if (num <= len)
                    set.add(num);
            }
        }

        for (int i = 1; i <= len; i++) {
            if (set.contains(i) && res == i) {
                res++;
            }
        }

        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
//        int[][] nums = {{3, 1, 4}, {5, 8, 10}};
//        int[][] nums = {{3, 1, 4}, {5, 2, 10}};
        int[][] nums = {{3, 1, 4}, {5, 2, 6}};
        System.out.println(findMin(nums));
    }

}
