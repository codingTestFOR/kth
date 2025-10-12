package 스터디용.그래프이론;

import java.util.*;

public class 커리큘럼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n 입력 : ");
        int n = sc.nextInt();
        int[] indegree = new int[n + 1];
        int[] time = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 입력
        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
            while (true) {
                int x = sc.nextInt();
                if (x == -1) break;
                graph.get(x).add(i);
                indegree[i]++;
            }
        }

        topologySort(n, indegree, time, graph);
    }

    public static void topologySort(int v, int[] indegree, int[] time, ArrayList<ArrayList<Integer>> graph) {
        // 주의 - 깊은 복사 사용할 것
        int[] result = Arrays.copyOf(time, time.length);
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 위상 정렬
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                result[next] = Math.max(result[next], result[now] + time[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= v; i++) {
            System.out.println(result[i]);
        }
    }
}
