package 연습풀이.예제;

import java.util.Scanner;

public class 상하좌우 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n 입력 받기
        System.out.println("n 입력 : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        // 계획 입력 받기
        System.out.println("계획 입력 : ");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();

        int[] dx = {-1, 1};
        int[] dy = {-1, 1};

        int[] start = {1, 1};

        for (char c : chars) {
            if (c == 'L') {
                start[1] += dx[0];
            } else if (c == 'R') {
                start[1] += dx[1];
            } else if (c == 'U') {
                start[0] += dy[0];
            } else if (c == 'D') {
                start[0] += dy[1];
            }

            // 공간 벗어나는지 확인
            if (start[0] < 1) {
                start[0] = 1;
            } else if (start[0] > n) {
                start[0] = n;
            }

            if (start[1] < 1) {
                start[1] = 1;
            } else if (start[1] > n) {
                start[1] = n;
            }

        }

        System.out.println("start = " + start[0] + " " + start[1]);
    }
}
