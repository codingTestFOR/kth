package fs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CompetitiveContagion {
    public static int n, k, s, x, y;
    public static int[][] map;
    // 바이러스 담는 리스트 미리 생성
    public static ArrayList<Virus> viruses = new ArrayList<Virus>();


    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input n k
        System.out.println("n k 입력 : ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // input map
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스 존재시
                if (map[i][j] != 0) {
                    // 리스트에 삽입
                    viruses.add(new Virus(map[i][j], 0, i, j));
                }
            }
        }

        // input s x y
        System.out.println("s x y 입력 : ");

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        // 큐 생성 후 virus 낮은 번호부터 모두 투입
        // 이 소팅을 위해 Comparable 인터페이스 구현(그렇지 않으면 스트림을 이용해야함)
        Collections.sort(viruses);
        Queue<Virus> q = new ArrayDeque<Virus>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer(viruses.get(i));
        }

        // bfs
        // 큐가 비면 종료
        while (!q.isEmpty()) {
            Virus virus = q.poll();
            // 주어진 시간에 종료
            if (virus.second == s) break;
            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];
                // 맵 내부 확인
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 0인 경우 전파
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = virus.type;
                        q.offer(new Virus(virus.type, virus.second + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(map[x - 1][y - 1]);
    }
}

class Virus implements Comparable<Virus>{
    // 종류, 시간, 위치
    public int type, second, x, y;

    public Virus(int type, int second, int x, int y) {
        this.type = type;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    // 객체의 서열을 type을 기준으로
    @Override
    public int compareTo(Virus o) {
        if (this.type < o.type) {
            return -1;
        }
        return 1;
    }
}

