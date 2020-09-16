package exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1291_sequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        String base = "0123456789";
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
//                System.out.println(j + " " + (j + i) + " " + base.substring(j, j + i));
                if (j + i > 10)
                    break;
                Integer num = Integer.valueOf(base.substring(j, j + i));
                if (num < low)
                    continue;
                if (num > high)
                    break;
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1291_sequentialDigits ll = new LC1291_sequentialDigits();
        List<Integer> list = ll.sequentialDigits(100, 300);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
