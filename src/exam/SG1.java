package exam;

public class SG1 {
    /**
     *  一个a一个b一个c可以换一个奖品
     *  两个道具任意换一个道具
     *  一共能换多少奖品
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int numberofprize(int a, int b, int c) {
        int res = 0;

        int min = Math.min(a, b);
        min = Math.min(min, c);
        res += min;
        a -= min;
        b -= min;
        c -= min;

        while (true) {
            int zeros = 0;
            if (a == 0) zeros++;
            if (b == 0) zeros++;
            if (c == 0) zeros++;

            if (zeros == 3) break;
            if (zeros == 2 && a + b + c < 5) break;

            if (zeros == 2) {
                int sum = a + b + c;
                res += sum / 5;
                break;
            }

            if (zeros == 1) {
                int sum = a + b + c;
                if (sum < 4) break;

                int big = Math.max(a, b);
                big = Math.max(big, c);
                int small = sum - big;

                if (big == small) {
                    res += big / 2;
                    break;
//                    if (big == 2) {
//                        break;
//                    }
//                    if (big % 2 == 0) {
//                        res += (big - 2) / 2;
//                    } else {
//                        res += (big - 1) / 2;
//                    }
//                    break;
                }

                while (big != 0 && small != 0) {
                    if (big - small >= 4) {
                        big -= 3;
                        small -= 1;
                        res++;

                    } else {
                        big -= 2;
                        small -= 2;
                        res++;
                    }
                }

                a = big;
                b = small;
                c = 0;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        SG1 ll = new SG1();

        System.out.println(ll.numberofprize(2, 2, 0));
    }
}
