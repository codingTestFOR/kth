package 스터디용.최단경로;

import java.util.*;

public class 전보 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("n m c 입력 : ");
        // N, M, C 입력 받기
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println("그래프 입력 : ");
        // 그래프 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 최소 비용 배열 초기화
        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int)1e9);

        // 간선 초기화
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            graph.get(start).add(new Node(end, cost));
        }

        // 다익스트라 함수 호출
        dijkstra(c, graph, distance);

        // 도시 C에서 보낸 메시지를 받게 되는 도시의 개수
        int count = 0;
        // 도시 C에서 보낸 메시지를 받을 수 있는 도시들이 모두 메시지를 받는 데까지 걸리는 시간
        int max = 0;
        for (int d : distance) {
            // 도달할 수 있는 노드인 경우
            if (d < (int)1e9) {
                count++;
                if (d > max) {
                    max = d;
                }
            }
        }

        // 시작 노드는 제거해야 하므로 count - 1 출력
        System.out.println((count - 1) + " " + max);

        scanner.close();
    }

    public static void dijkstra(int start, ArrayList<ArrayList<Node>> graph, int[] distance) {
        // 시작 노드 비용 초기화
        distance[start] = 0;

        // 우선 순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드를 우선 순위 큐에 삽입 (비용, 도착 노드)
        pq.offer(new Node(start, 0));

        // 우선 순위 큐 탐색
        while (!pq.isEmpty()) {
            // 우선순위큐에서 최소 비용 노드 추출
            Node current = pq.poll();
            int now = current.getIndex();
            int cost = current.getDistance();

            // 시작 노드에서 추출한 노드까지의 비용이
            // 시작 노드에서 추출 노드까지의 현재 비용보다 클 경우는 진행하지 않음
            if (cost > distance[now]) {
                continue;
            }

            // 추출 노드와 인접한 노드 확인
            for (Node neighbor : graph.get(now)) {
                // 시작 노드와 인접한 노드 간 기존 비용 vs 추출 노드를 거쳐갈 때의 비용
                int newCost = cost + neighbor.getDistance();
                if (distance[neighbor.getIndex()] > newCost) {
                    // 최소 비용 배열 업데이트
                    distance[neighbor.getIndex()] = newCost;
                    // 우선순위큐에 업데이트 내용 삽입
                    pq.offer(new Node(neighbor.getIndex(), newCost));
                }
            }
        }
    }

    // 노드 클래스 정의
    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        // 우선순위 큐에서 거리가 짧은 것이 우선되도록 비교 함수 구현
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
