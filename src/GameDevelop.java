import java.util.Scanner;

public class GameDevelop {
    // 필요한  변수 설정
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int x, y, direction;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1 크기 입력
        N = scanner.nextInt();
        M = scanner.nextInt();

        // 2 현재 위치 및 방향 입력
        x = scanner.nextInt();
        y = scanner.nextInt();
        direction = scanner.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        // 3 지도 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        visited[x][y] = true;
        int result = 1;
        int turnCount = 0;

        while (true) {
            // 모두 가 본 경우
            if (turnCount == 4) {
                // 후진
                int backX = x - dx[direction];
                int backY = y - dy[direction];

                // 바다면 루프 끝
                if (map[backX][backY] == 1) break;

                // 육지면 후진 후 초기화
                x = backX;
                y = backY;
                turnCount = 0;
            }

            // 회전
            turnLeft();
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            // 방문 x and 육지
            if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                x = nextX;
                y = nextY;
                visited[x][y] = true;
                result++;
                turnCount = 0;
            } else {
                turnCount++;
            }
        }

        System.out.println(result);
    }

    public static void turnLeft() {
        direction = (direction - 1 + 4) % 4;
    }
}
