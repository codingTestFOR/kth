package 연습풀이.백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        /*
        // 이 방식은 IO 버퍼로 인해 시간 초과
        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st2.nextToken());
            if (map.containsKey(card)) {
                System.out.print(map.get(card) + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
         */

        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st2.nextToken());
            sb.append(map.getOrDefault(card, 0)).append(" ");
        }

        System.out.println(sb);

    }
}
