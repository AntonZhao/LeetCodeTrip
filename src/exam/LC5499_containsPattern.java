package exam;

public class LC5499_containsPattern {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (k > arr.length)
            return false;
        if (m == 1 && k == 1)
            return true;
        if (m * k > arr.length)
            return false;

        String s = "";
        for (int i : arr) {
            s = s + i;
        }

        for (int i = 0; i <= arr.length - m * k; i++) {
            String curr = s.substring(i, i + m);
            String want = "";
            for (int j = 0; j < k; j++) {
                want = want + curr;
            }
            if (s.indexOf(want) != -1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC5499_containsPattern ll = new LC5499_containsPattern();

        int[] nums = new int[]{1, 2, 4, 4, 4, 4};
        System.out.println(ll.containsPattern(nums, 1, 3));
    }
}
