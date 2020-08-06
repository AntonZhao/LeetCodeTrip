public class LC151_reverseWords {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" +");
        String res = strings[strings.length - 1];
        for (int i = strings.length - 2; i >= 0; i--) {
            res += " " + strings[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LC151_reverseWords ll = new LC151_reverseWords();

//        String s = "  a good   example     ";
        String s = "  hello world!  ";
        System.out.println("****" + ll.reverseWords(s) + "*********");
    }
}
