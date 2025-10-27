package 연습풀이.백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        Set<String> set2 = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M ; i++) {
            String s = br.readLine();
            if (set.contains(s)) set2.add(s);
        }

        System.out.println(set2.size());
        StringBuilder sb = new StringBuilder();
        for (String s : set2) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
