package 연습풀이.백준.자료구조;

import java.io.*;
import java.util.*;

public class No_11725 {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        bfs(1);

        for (int i = 2; i <= N; i++) System.out.println(parent[i]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : tree[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }
            }
        }
    }
}