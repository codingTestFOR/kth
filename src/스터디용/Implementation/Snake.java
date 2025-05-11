package 스터디용.Implementation;
import java.util.*;

public class Snake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n 입력 :");
        int n = sc.nextInt();
        System.out.println("사과 개수 입력 :");
        int apple = sc.nextInt();

        int[][] data = new int[n + 1][n + 1];
        List<int[]> info = new ArrayList<>();

        System.out.println("사과 위치 입력 :");
        // 맵 정보(사과 위치 입력)
        for (int i = 0; i < apple; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            data[a][b] = 1;
        }

        System.out.println("전환 횟수 입력 :");
        int l = sc.nextInt();

        System.out.println("시간 및 방향 입력 :");
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            String c = sc.next();
            info.add(new int[]{x, c.equals("L") ? -1 : 1}); // 'L'은 -1, 'D'는 +1로 저장
        }

        System.out.println(simulate(n, data, info));
    }

    public static int simulate(int n, int[][] data, List<int[]> info) {
        // 동, 남, 서, 북
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 1, y = 1; // 뱀의 머리 위치
        data[x][y] = 2; // 뱀이 존재하는 위치는 2로 표시
        int direction = 0; // 초기 방향 동쪽
        int time = 0;
        int index = 0;

        Queue<int[]> q = new LinkedList<>(); // 뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
        q.offer(new int[]{x, y});

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 뱀의 몸통이 없는 위치라면
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && data[nx][ny] != 2) {
                if (data[nx][ny] == 0) { // 사과가 없다면 이동 후에 꼬리 제거
                    data[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                    int[] tail = q.poll();
                    data[tail[0]][tail[1]] = 0;
                } else if (data[nx][ny] == 1) { // 사과가 있다면 이동 후에 꼬리 그대로 두기
                    data[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            } else { // 벽이나 뱀의 몸통과 부딪혔다면
                time++;
                break;
            }

            x = nx;
            y = ny;
            time++;

            if (index < info.size() && time == info.get(index)[0]) { // 회전할 시간인 경우 회전
                direction = (direction + info.get(index)[1] + 4) % 4; // 방향 전환 처리
                index++;
            }
        }

        return time;
    }
}
