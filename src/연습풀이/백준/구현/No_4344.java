package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        double[] avgArr = new double[t];

        for (int i = 0; i < avgArr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            double sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            int count = 0;
            for (double d : arr) {
                if (d > sum/n) count++;
            }

            avgArr[i] = (double) count / n * 100;
        }

        for (int i = 0; i < t; i++) {
            System.out.printf("%.3f%%%n", avgArr[i]);
        }
    }
}
