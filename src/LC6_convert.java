import java.util.ArrayList;
import java.util.List;

public class LC6_convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }
//        List<String> res = new ArrayList<>(numRows);
        int n = numRows + numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int temp = i % n;
            if (temp < numRows) {
                res[temp].append(s.charAt(i));
            } else {
                res[n - temp].append(s.charAt(i));
            }
        }
        StringBuilder rr = new StringBuilder();
        for (StringBuilder sb : res) {
            rr.append(sb);
        }
        return rr.toString();
    }

    public static void main(String[] args) {
        LC6_convert ll = new LC6_convert();
        System.out.println(ll.convert("LEETCODEISHIRING", 1));
    }
}
