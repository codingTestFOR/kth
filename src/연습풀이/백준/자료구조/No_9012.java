package 연습풀이.백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String bracket = br.readLine();
            int count = 0;
            boolean valid = true;
            for (char c : bracket.toCharArray()) {
                if (c == '(') count++;
                else count--;

                if (count < 0) {
                    valid = false;
                    break;
                }
            }
            System.out.println((count == 0) && valid ? "YES" : "NO");
        }
    }
}
