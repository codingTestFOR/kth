package 스터디용.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미래도시 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println("n m 입력 : ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];

        // 그래프 초기화 (Integer.MAX_VALUE로 설정하여 무한대를 표현)
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        // 그래프 대각선 초기화 (자기 자신으로 가는 비용은 0)
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        System.out.println("그래프 입력 : ");
        // 양방향 간선 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        System.out.println("x k 입력 : ");
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 플로이드 워셜 알고리즘 실행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (graph[a][i] != Integer.MAX_VALUE && graph[i][b] != Integer.MAX_VALUE) {
                        graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                    }
                }
            }
        }

        // 1번 노드에서 K 노드로 가는 최소 비용 + K 노드에서 X 노드로 가는 최소 비용 계산
        int distance = graph[1][k] + graph[k][x];

        // 도달할 수 있을 경우
        if (distance < Integer.MAX_VALUE) {
            System.out.println(distance);
        }
        // 도달할 수 없을 경우
        else {
            System.out.println(-1);
        }
    }
}