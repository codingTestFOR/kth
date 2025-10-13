package 연습풀이.예제;

import java.util.Scanner;

public class 게임개발 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n, m 입력 : ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        System.out.println("x, y, d 입력 : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int d = scanner.nextInt();

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 로직 시작
        visited[x][y] = true;
        int count = 1;
        int turn = 0;
        while (true) {
            // 회전
            d = (d + 4 - 1) % 4;
            // 회전시 이동 좌표
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 이동 가능시
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0 && !visited[nx][ny]) {
                x = nx;
                y = ny;
                turn = 0;
                count++;
                visited[x][y] = true;
            } else turn++;

            // 4 회전 완료
            if (turn == 4) {
                int bx = x - dx[d];
                int by = y - dy[d];
                if (map[bx][by] == 1) break;
                x = bx;
                y = by;
                turn = 0;
            }


        }
        System.out.println(count);

    }
}
