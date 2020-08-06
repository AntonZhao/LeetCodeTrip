import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC914_hasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int x = 0;
        for (Integer value : map.values()) {
            x = gcd(x, value);
            if (x == 1) return false;
        }
        return true;
    }

    private int gcd(Integer a, Integer b) {
        if (a == 0) return b;
        int min = Math.min(a, b);
        int max = a + b - min;
        for (int i = min; i >= 1; i--) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        LC914_hasGroupsSizeX ll = new LC914_hasGroupsSizeX();
//        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1, 5, 5, 6, 6,7,7,8,8,8};
//        int[] deck = {1, 1};
//        int[] deck = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        int[] deck = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(ll.hasGroupsSizeX(deck));

        int a = 0;
        sswap(a++);
        System.out.println(a);
    }

    private static void sswap(int i) {
        System.out.println(i);
    }
}
