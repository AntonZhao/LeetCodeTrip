package exam;

public class LC5492_numWays {
    public int numWays(String s) {
        if (s.equals("") || s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int ones = 0;
        for (char c : chars) {
            if (c == '1') ones++;
        }

        if (ones % 3 != 0) {
            return 0;
        }

        long res = 0;
        if (ones == 0) {
            long n = chars.length - 1;
            res = n * (n - 1) / 2;
        } else {
            int one_part = ones / 3;
            long[] need = new long[4];
            boolean[] visited = new boolean[4];

            int counter = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '1') {
                    counter++;
                    if (counter == one_part && !visited[0]) {
                        need[0] = i;
                        visited[0] = true;
                    }
                    if (counter == one_part + 1 && !visited[1]) {
                        need[1] = i;
                        visited[1] = true;
                    }
                    if (counter == one_part * 2 && !visited[2]) {
                        need[2] = i;
                        visited[2] = true;
                    }
                    if (counter == one_part * 2 + 1 && !visited[3]) {
                        need[3] = i;
                        visited[3] = true;
                    }
                }
            }
//            System.out.println(need[0] + " " + need[1] + " " + need[2] + " " + need[3]);
            res = (need[1] - need[0]) * (need[3] - need[2]);
        }
        res = res % 1000000007;
        return (int) res;
    }

    public static void main(String[] args) {
        LC5492_numWays ll = new LC5492_numWays();
        System.out.println(ll.numWays("10101"));

        long l = 49001l * 49001l;
        System.out.println(l);

    }
}
