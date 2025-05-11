package 스터디용.Implementation;

import java.util.Scanner;

public class KingsKnight {
    //변수 설정
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, 2, -2, 2, -2, -1, 1};
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("현재 위치 입력 : ");
        // 1 현재 위치
        String input = scanner.nextLine();
        int col = input.charAt(0) - 'a' + 1;
        int row = input.charAt(1) - '0';

        for (int i = 0; i < 8; i++) {
            // 2 이동
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            // 3 이동 가능 카운트
            if (nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <= 8) {
                count++;
            }
        }

        System.out.println("count = " + count);
    }
}
