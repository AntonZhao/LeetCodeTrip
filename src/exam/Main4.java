package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main4 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");

        System.out.println(removeK("88899192345", 2));
    }

    /**
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小；
     */

    public static String removeK(String str, int k) {
        if (k >= str.length()) return "0";

        char[] num = str.toCharArray();
        StringBuilder res = new StringBuilder();

        TreeMap<Character, List<Integer>> map = new TreeMap<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                List<Integer> temp = map.get(num[i]);
                temp.add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(num[i], temp);
            }
        }

        for (char key : map.keySet()) {
            List<Integer> currList = map.get(key);
            while (currList.size() > 0) {
                Integer remove = currList.get(0);
                currList.remove(0);
                num[remove] = 'X';
                if (--k == 0) break;
            }
            if (k == 0) break;
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] != 'X') {
                res.append(num[i]);
            }
        }
        return res.toString();
    }
}
