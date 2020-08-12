import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC60_getPermutation {
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";

        StringBuilder builder = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        int BIG = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            BIG *= i;
        }
        k--;

        while (n > 1) {
            BIG = BIG / n--;
            builder.append(list.get(k / BIG));
            list.remove(k / BIG);
            k = k % BIG;

        }
        builder.append(list.get(0));
        return builder.toString();
    }


    public static void main(String[] args) {
        LC60_getPermutation ll = new LC60_getPermutation();
//        System.out.println(ll.getPermutation(3, 3));
//        System.out.println(ll.getPermutation(4, 9));
//        System.out.println(ll.getPermutation(9, 1000));
//        System.out.println(ll.getPermutation(1, 1));
//        System.out.println(ll.getPermutation(2, 1));


        System.out.println(ll.getPermutation(4, 1));


    }
}
