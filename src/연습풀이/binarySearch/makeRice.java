package 연습풀이.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class makeRice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("n m 입력 : ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        System.out.println("떡길이 입력 : ");
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arrN = new int[n];

        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arrN);

        System.out.println(loop(arrN, m));

    }

    // 반복문
    public static int loop(int[] arr, int target){
        int result = 0;
        int start = 0;
        int end = Arrays.stream(arr).max().getAsInt();
        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < arr.length; i++) {
                sum += (arr[i] >= mid) ? arr[i] - mid : 0;
            }

            if (sum >= target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
