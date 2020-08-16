public class LC402_removeKdigits {

    public String removeKdigits(String str, int k) {
        if (k >= str.length()) return "0";

        StringBuilder res = new StringBuilder(str);
        for (int i = 0; i < k; i++) {

            int removeIndex = 0;
            for (int j = 1; j < res.length() && res.charAt(j) >= res.charAt(j - 1); j++) {
                removeIndex = j;
            }

            res.delete(removeIndex, removeIndex + 1);

            while (res.length() > 1 && res.charAt(0) == '0')
                res.delete(0, 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LC402_removeKdigits ll = new LC402_removeKdigits();
        System.out.println(ll.removeKdigits("10000", 3));
    }
}
