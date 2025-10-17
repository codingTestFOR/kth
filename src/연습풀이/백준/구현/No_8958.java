package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] arr = new String[t];

        for (int i = 0; i < t; i++) {
            arr[i] = br.readLine();
        }

        for (String s : arr) {
            int result = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'O') {
                    count++;
                    result += count;
                } else if (s.charAt(i) == 'X') {
                    count = 0;
                }

            }
            System.out.println(result);
        }
    }
}
