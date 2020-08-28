package exam;

import java.util.Scanner;

/**
 * 快速计算出由2、3、5这三个数字组成的由小到大的第n个数，当然也包括2、3和5。
 *
 * 赵鑫你真是个傻逼，这种题都想了这么久。
 */
public class JD_Main1 {
    public static void main(String[] args) {

        for (int n = 1; n <= 500; n++) {
            System.out.print("" + n + "\t:");
            if (n == 1) {
                System.out.println("2");
            } else if (n == 2) {
                System.out.println("3");
            } else if (n == 3) {
                System.out.println("5");
            } else {
                ffff(n);
            }
        }

    }

    public static void ffff(int n) {
        int digits = 1, count = 3, prevCount = 0;
        while (n > count) {
            int temp = prevCount;
            prevCount = count;
            count = count + (count - temp) * 3;
            digits++;
        }

        int offset = n - prevCount;
        char[] res = new char[digits];
        for (int i = 0; i < digits; i++) {
            res[i] = '2';
        }

        offset--;
        char[] base2= new char[]{ '2', '3', '5'};
        for (int i = digits - 1; i >= 0; i--) {
            res[i] = base2[offset % 3];
            offset = offset / 3;

        }

        for (int i = 0; i < digits; i++) {
            System.out.print(res[i]);
        }
        System.out.println();
    }
}
