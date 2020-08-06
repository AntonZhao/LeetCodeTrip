import java.util.Scanner;

public class LC125_isPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(isPalindrome(sc.nextLine()));
        }
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            while (head < tail && !isNumberOrLettter(s.charAt(head))) head++;
            while (head < tail && !isNumberOrLettter(s.charAt(tail))) tail--;
            if (!isNumberOrLettter(s.charAt(head)) || !isNumberOrLettter(s.charAt(tail))) return false;
            if (s.charAt(head) != s.charAt(tail)) return false;
            head++;
            tail--;
        }
        return true;
    }

    private static boolean isNumberOrLettter(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}
