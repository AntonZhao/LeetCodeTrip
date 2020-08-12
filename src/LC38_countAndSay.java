import java.util.HashMap;
import java.util.Map;

public class LC38_countAndSay {
    public String countAndSay(int n) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "11");
        map.put(3, "21");
        map.put(4, "1211");
        map.put(5, "111221");

        for (int i = 6; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char[] prev = map.get(i - 1).toCharArray();
            char currChar= prev[0];
            int currCount = 1;
            for (int j = 1; j < prev.length; j++) {
                if (prev[j] == currChar) {
                    currCount++;
                } else {
                    builder.append(currCount);
                    builder.append(currChar);
                    currChar = prev[j];
                    currCount = 1;
                }
            }
            builder.append(currCount);
            builder.append(currChar);

            map.put(i, builder.toString());
        }

        return map.get(n);
    }

    public static void main(String[] args) {
        LC38_countAndSay ll = new LC38_countAndSay();
        System.out.println(ll.countAndSay(10));
    }
}
