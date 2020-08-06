import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通配符匹配
 */
public class LC44_isMatch {
    //优雅牛逼的方法
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    //DP, 时间一般，但是好懂
    public boolean isMatch_dp(String s, String p) {
        if (p == null || p.isEmpty())
            return s == null || s.isEmpty();

        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];

        //初始化dp数组,dp[1][0]~dp[s.length][0]默认值flase不需要显式初始化为false
        dp[0][0] = true;
        //dp[0][1]~dp[0][p.length]只有p的j字符以及前面所有字符都为'*'才为true
        for (int j = 1; j <= plen; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }
        //填写dp数组剩余部分
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                char si = s.charAt(i - 1), pj = p.charAt(j - 1);
                if (si == pj || pj == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pj == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[slen][plen];
    }

    // 递归，超出时间限制
    public boolean isMatch_recursion(String s, String p) {
        //terminator
        if (s.equals(p)) {
            return true;
        }
        if (!s.isEmpty() && p.isEmpty()) {
            return false;
        }
        if (s.isEmpty()) {
            for (char c : p.toCharArray()) {
                if (c != '*')
                    return false;
            }
            return true;
        }
        //process
        if (p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            // 匹配一个字符 || 不匹配字符 || 匹配多个字符
            return isMatch(s.substring(1), p.substring(1)) || isMatch(s, p.substring(1))
                    || isMatch(s.substring(1), p);
        } else if (p.charAt(0) == s.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        LC44_isMatch ll = new LC44_isMatch();
        String s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
        String p = "***bba**a*bbba**aab**b";
        System.out.println(ll.isMatch(s, p));

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(null, 1);
        map.put(null, null);


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(13);
        list.add(13);
        list.add(14);
        Object[] la = list.toArray();
        Integer[] aa = {1, 2, 3, 4, 5};
        System.out.println(la[1].equals(1));
        System.out.println(aa[1].equals(11));
        System.out.println(la.getClass());
        Arrays.stream(aa).filter(integer -> integer > 1);
        System.out.println(aa[0]);
        System.gc();
    }
}
