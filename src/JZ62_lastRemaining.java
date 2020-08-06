import java.util.ArrayList;

public class JZ62_lastRemaining {

    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining_(int n, int m) {
        int p = 0;

        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }

        return p;
    }

    public static void main(String[] args) {
        JZ62_lastRemaining ll = new JZ62_lastRemaining();
        System.out.println(ll.lastRemaining(6, 3));
        String s= "ss";
        s.length();
    }
}
