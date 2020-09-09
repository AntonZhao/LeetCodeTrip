package exam;

import java.util.Scanner;

public class XM1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] pwds = input.trim().split(" ");

        for (String pwd : pwds) {
            if (pwd.length() < 8 || pwd.length() > 120) {
                System.out.println(1);
                continue;
            }
            boolean seeNum = false;
            boolean seeSign = false;
            boolean seeBig = false;
            boolean seeSmall = false;

            char[] chars = pwd.toCharArray();
            for (char c : chars) {
                if (seeNum && seeBig && seeSign && seeSmall)
                    break;
                if (c >= '0' && c <= '9') {
                    seeNum = true;
                } else if (c >= 'a' && c <= 'z') {
                    seeSmall = true;
                } else if (c >= 'A' && c <= 'Z') {
                    seeBig = true;
                } else {
                    seeSign = true;
                }

            }

            if (seeNum && seeBig && seeSign && seeSmall) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }

        scanner.close();
    }
}
