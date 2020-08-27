import java.util.*;

public class LC646_findLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int res = 1;
        int temp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][1] > temp) {
                res++;
                temp = pairs[i][1];
            }
        }

        return res;
    }
}
