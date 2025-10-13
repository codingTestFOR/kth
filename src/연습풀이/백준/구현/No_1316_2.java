package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1316_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            boolean[] visited = new boolean[26];
            char prev = 0;
            boolean isGroup = true;

            for (int j=0;j<str.length();j++){
                char c = str.charAt(j);
                if (c != prev){
                    if (visited[c - 'a']) {
                        isGroup = false;
                        break;
                    }
                }
                visited[c - 'a'] = true;
                prev = c;
            }
            if (isGroup) count++;
        }

        System.out.println(count);
    }
}
