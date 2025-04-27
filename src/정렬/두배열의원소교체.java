package 정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 두배열의원소교체 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // n과 k 입력 받기
        System.out.println("n k 입력 : ");
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 배열 a 입력 받기
        System.out.println("a 입력 : ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 풀이 1 int 배열 b > 오름차순 이후 뒤집기
//        System.out.println("b 입력 : ");
//        int[] b = new int[n];
//        for (int i = 0; i < n; i++) {
//            b[i] = sc.nextInt();
//        }
//
//        long startTime = System.nanoTime();
//        // a는 오름차순 정렬
//        Arrays.sort(a);
//        // b도 우선 a와 동일하게 우선 오름차순
//        Arrays.sort(b);
//        // b 배열 뒤집기
//        for (int i = 0; i < n / 2; i++) {
//            int temp = b[i];
//            b[i] = b[n - i - 1];
//            b[n - i - 1] = temp;
//        }

        // 풀이 2 Integer 배열 b > 바로 내림차순
        System.out.println("b 입력 : ");
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        long startTime = System.nanoTime();
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder()); // 내림차순 정렬

        // 최대 k번 비교하여 교체
        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else {
                break;
            }
        }

        // 배열 a의 합 계산
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        // 결과 출력
        /*
        집 컴퓨터 기준 두 풀이의 시간은 대략 2배 차이
         */
        System.out.println(sum);
        long endTime = System.nanoTime();
        System.out.println("exec: " + (endTime - startTime));
    }
}
