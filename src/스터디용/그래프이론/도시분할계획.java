package 스터디용.그래프이론;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 도시분할계획 {
    static int[] parent;

    // +경로 압축
    public static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    // 간선 클래스
    static class Edge implements Comparable<Edge> {
        int cost;
        int nodeA;
        int nodeB;

        Edge(int cost, int nodeA, int nodeB) {
            this.cost = cost;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n m 입력 : ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        System.out.println("간선 입력 : ");
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, a, b));
        }

        // 비용 기준 정렬
        Collections.sort(edges);

        // 크루스칼 알고리즘
        for (Edge edge : edges) {
            if (findParent(parent, edge.nodeA) != findParent(parent, edge.nodeB)) {
                unionParent(parent, edge.nodeA, edge.nodeB);
                result.add(edge.cost);
            }
        }

        // 가장 큰 비용을 제외한 총합 계산
        Collections.sort(result);
        int totalCost = 0;
        for (int i = 0; i < result.size() - 1; i++) {
            totalCost += result.get(i);
        }

        System.out.println(totalCost);
    }
}
