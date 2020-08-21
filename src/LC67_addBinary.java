public class LC67_addBinary {
    public String addBinary(String a, String b) {
        a = a.trim();
        b = b.trim();
        if (a.equals("0") && b.equals("0")) return "0";
        if (a.equals("0")) return b;
        if (b.equals("0")) return a;

        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();
        StringBuilder res = new StringBuilder();

        boolean carry = false;
        int pa = cha.length - 1;
        int pb = chb.length - 1;
        while (pa >= 0 || pb >= 0) {
            int aa = pa >= 0 ? cha[pa] - '0' : 0;
            int bb = pb >= 0 ? chb[pb] - '0' : 0;
            pa--;
            pb--;
            int cc = aa + bb + (carry ? 1 : 0);
            res.append(cc % 2);
            carry = cc >= 2;
        }

        if (carry) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        LC67_addBinary ll = new LC67_addBinary();
        System.out.println(ll.addBinary("0", "0"));
    }
}
