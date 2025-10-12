package 연습풀이.예제;

import java.util.Scanner;

public class 럭키스트레이트 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;

        for (int i = 0; i < chars.length / 2; i++) {
            left += chars[i] - '0';
            right += chars[chars.length/2 + i] - '0';
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }
}
