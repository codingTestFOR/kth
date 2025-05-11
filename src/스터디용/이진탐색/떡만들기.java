package 스터디용.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 떡만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n m 입력 : ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println("떡길이 입력 : ");
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
        }

        // 이진 탐색을 위해 소팅
        Arrays.sort(arrN);

        System.out.println(loop(arrN, m));
    }

    // 반복문
    public static int loop(int[] arr, int target){
        int result = 0;
        int start = 0;
        // 오름차순 정렬된 배열이므로 마지막 인덱스가 끝점
        int end = arr[arr.length - 1];
        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;

            // 높이에 맞춰 자르기
            for (int i = 0; i < arr.length; i++) {
                sum += (arr[i] >= mid) ? arr[i] - mid : 0;
            }

            // 자른 후 떡의 길이와 m 비교
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
