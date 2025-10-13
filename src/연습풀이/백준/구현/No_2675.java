package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] arr = new String[t];

        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                for (int j=0;j<r;j++) {
                    sb.append(c);
                }
            }
            arr[i] = sb.toString();
        }
        for(int i=0;i<t;i++) {
            System.out.println(arr[i]);
        }

    }
}
