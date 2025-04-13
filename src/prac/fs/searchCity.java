package prac.fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class searchCity {
    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] d;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("n m 입력 : ");
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 최단거리 배열 생성
        d = new int[n + 1];

        // 인접 리스트의 노드별 리스트 생성 및 최단 거리 요소 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        System.out.println("도로 정보 입력 : ");

        for (int i = 0; i < m; i++) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }



        // x로의 거리 0 설정
        d[x] = 0;

        // 최단 거리 계산
        bfs(x);

        // 오름차순 출력
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                result++;
            }
        }

        System.out.println(result > 0 ? "" : -1);
    }

    public static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                if (d[nextNode] == -1) {
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }
    }
}
