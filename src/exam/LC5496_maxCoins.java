package exam;

import java.util.Arrays;

public class LC5496_maxCoins {
    public int maxCoins(int[] piles) {

        Arrays.sort(piles);

        int times = piles.length / 3;
        int res = 0;
        int index = piles.length - 2;
        while (times > 0) {
            res += piles[index];
            index -= 2;
            times--;
        }

        return res;
    }
}
