package exam;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XHS1 {

    /**
     * 请完成下面这个函数，实现题目要求的功能
     * 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
     * *************************开始写代码*****************************
     */
    static int[] subSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return new int[]{-1, -1};

        int len = nums.length;

        int start = -1, end = -1;
        int max = nums[0];
        int min = nums[len - 1];

        for (int i = 1; i < len; i++) {
            if (max > nums[i]) {
                end = i;
            } else if (max < nums[i]) {
                max = nums[i];
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (min < nums[i]) {
                start = i;
            } else if (min > nums[i]) {
                min = nums[i];
            }
        }

        return new int[]{start, end};
    }

    static int[] subSort2(int[] nums) {
        if (nums == null || nums.length <= 1)
            return new int[]{-1, -1};
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp);
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                if (left == -1) {
                    left = i;
                }
                right = i;
            }
        }

        return new int[]{left, right};
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[] res;
//
//        int _arr_size = 0;
//        _arr_size = Integer.parseInt(in.nextLine().trim());
//        int[] _arr = new int[_arr_size];
//        int _arr_item;
//        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
//            _arr_item = Integer.parseInt(in.nextLine().trim());
//            _arr[_arr_i] = _arr_item;
//        }
//
//        res = subSort(_arr);
//        for (int res_i = 0; res_i < res.length; res_i++) {
//            System.out.println(String.valueOf(res[res_i]));
//        }
        int[] sort = subSort(new int[]{1, 2, 3, 4, 10, 7, 9, 8, 8, 12, 13, 14, 19});
//        int[] sort = subSort(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(sort[0] + " " + sort[1]);

    }

}
