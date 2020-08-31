public class LC557_reverseWords {

    /**
     * 需要额外空间
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = words[0].length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        for (int i = 1; i < words.length; i++) {
            builder.append(" ");
            for (int j = words[i].length() - 1; j >= 0; j--) {
                builder.append(words[i].charAt(j));
            }
        }
        return builder.toString();
    }

    public String reverseOnlyLetters(String S) {
        int head = 0, tail = S.length() - 1;
        char[] chs = S.toCharArray();
        while (head < tail) {
            while (!Character.isLetter(chs[head])) head++;
            while (!Character.isLetter(chs[tail])) tail--;
            if (head >= tail) {
                break;
            }
            char temp = chs[head];
            chs[head++] = chs[tail];
            chs[tail--] = temp;
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        LC557_reverseWords ll = new LC557_reverseWords();
        System.out.println(ll.reverseWords("Let's take LeetCode contest"));

        System.out.println(ll.reverseOnlyLetters("a-bC-dEf-ghIj"));

    }


}
