package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2577 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String result = String.valueOf(A * B * C);

        int[] countArr = new int[10];

        for (int i = 0; i < result.length(); i++) {
            countArr[result.charAt(i) - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(countArr[i]);
        }
    }
}
