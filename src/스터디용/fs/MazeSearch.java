package 스터디용.fs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeSearch {
    public static int n, m;
    public static int[][] map;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};


    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int[] arr = {x, y};
        q.offer(arr);

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            // 큐에서 꺼낸 좌표
            int a = poll[0];
            int b = poll[1];
            // 신규 좌표
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = a + dx[i];
                ny = b + dy[i];

                // 예외1 노드가 맵 밖
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 예외2 괴물을 만남
                if (map[nx][ny] == 0) {
                    continue;
                }

                // 루트 기록
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[a][b] + 1;
                    int[] arr2 = {nx, ny};
                    q.offer(arr2);
                }
            }
        }

        return map[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n m 입력 :");
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];

        System.out.println("미로 입력 :");
        for (int i = 0; i < n ; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        System.out.println("\n입력된 map 배열:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        System.out.println(bfs(0, 0));
    }
}
