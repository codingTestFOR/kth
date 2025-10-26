package 연습풀이.백준.자료구조;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 덱 사용
public class No_1158_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        sb.append("<");

        while (!deque.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }

            sb.append(deque.pollFirst());
            if (!deque.isEmpty()) sb.append(", ");
        }

        sb.append(">");

        System.out.println(sb);
    }
}
