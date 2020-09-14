package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class NetEase1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strings = input.trim().split(" ");

        int[] seats = new int[strings.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            seats[i] = strings[i].charAt(0) - '0';
            if (seats[i] == 1) {
                list.add(i);
            }
        }

        if (list.size() == 1) {
            int temp_pos = list.get(0);
            int res = Math.max(temp_pos, seats.length - 1 - temp_pos);
            System.out.println(res);
        } else if (list.size() == seats.length - 1) {
            System.out.println(1);
        } else {
            int res = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int prev = list.get(i);
                int next = list.get(i + 1);
                res = Math.max(res, (next - prev) / 2);
            }
            res = Math.max(list.get(0), res);
            res = Math.max(seats.length - 1 - list.get(list.size() - 1), res);
            System.out.println(res);
        }

        sc.close();
    }
}
