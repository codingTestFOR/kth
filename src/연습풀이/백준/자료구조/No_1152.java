package 연습풀이.백준.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class No_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    int key = (n == 1) ? map.lastKey() : map.firstKey();
                    if (map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key);
                    }
                }
            }

            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.print(sb);
    }
}
