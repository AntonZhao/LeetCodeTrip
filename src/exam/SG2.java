package exam;

import java.util.Arrays;

public class SG2 {

    /**
     * 贴着边盖房子
     * @param t
     * @param xa
     * @return
     */

    public int getHouses(int t, int[] xa) {
        if (xa.length == 2) return 2;

        int res = 2;
        double[] pos = new double[xa.length];

        int pointer = 0;
        for (int i = 0; i < xa.length; i = i + 2) {
            pos[pointer++] = xa[i] - (xa[i + 1] / 2);
            pos[pointer++] = xa[i] + (xa[i + 1] / 2);
        }

//        Arrays.sort(pos);

        for (int i = 1; i < pos.length - 1; i = i + 2) {
            double next = pos[i + 1];
            if (next - pos[i] > t) {
                res += 2;
            } else if (next - pos[i] == t) {
                res += 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SG2 ll = new SG2();

        System.out.println(ll.getHouses(2, new int[]{-1, 4, 5, 8}));
    }

}
