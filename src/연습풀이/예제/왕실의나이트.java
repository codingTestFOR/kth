package 연습풀이.예제;

import java.util.Scanner;

public class 왕실의나이트 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 위치 입력
        System.out.println("위치 입력 : ");
        String s = scanner.nextLine();
        int x = s.charAt(0) - 'a' + 1;
        int y = s.charAt(1) - '0';
        int count = 0;

        int[][] arr = {
                {-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}
        };

        for (int[] ints : arr) {
            int nx = x + ints[0];
            int ny = y + ints[1];

            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                count++;
            }
        }

        System.out.println(count);

    }
}
