import java.util.Collections;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/cracking-the-safe/solution/javayu-yan-hierholzersuan-fa-he-de-bruijnxu-lie-by/
 */
public class LC753_crackSafe {

    TreeSet<String> visited;
    StringBuilder res;

    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        visited = new TreeSet<>();
        res = new StringBuilder();
        //  从顶点 00..0 开始
        String start = String.join("", Collections.nCopies(n - 1, "0"));
        findEuler(start, k);

        res.append(start);
        return res.toString();
    }

    private void findEuler(String currV, int k) {
        for (int i = 0; i < k; i++) {
            // 往顶点的 k 条出边检查，顶点加一条出边就是一种密码可能
            String nextV = currV + i;
            if (!visited.contains(nextV)) {
                visited.add(nextV);
                findEuler(nextV.substring(1), k);
                res.append(i);
            }
        }
    }


}
