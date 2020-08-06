import java.util.ArrayList;
import java.util.List;

public class JZ57_findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    temp[i - l] = i;
                }
                res.add(temp);
                l = l + 1;
                r = r + 1;
            } else if (sum < target) {
                ++r;
            } else {
                ++l;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        JZ57_findContinuousSequence jj = new JZ57_findContinuousSequence();
        System.out.println(jj.findContinuousSequence(9));
    }
}
