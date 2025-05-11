package 스터디용.이진탐색;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 부품찾기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("n 입력 : ");
        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        System.out.println("n 부품 번호 입력 : ");
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
        }

        // 이진 탐색을 위해 소팅
        Arrays.sort(arrN);

        System.out.println("m 입력 : ");
        int m = sc.nextInt();
        sc.nextLine();

        System.out.println("m 부품 번호 입력 : ");
        int[] arrM = new int[m+1];
        for (int i = 0; i < m; i++) {
            arrM[i] = sc.nextInt();
        }

        // arrN 출력
        System.out.print("정렬된 n 부품 배열: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arrN[i] + " ");
        }
        System.out.println(); // 줄바꿈

        // arrM 출력
        System.out.print("입력된 m 부품 배열: ");
        for (int i = 0; i < m; i++) {
            System.out.print(arrM[i] + " ");
        }
        System.out.println();

        for (int i : arrM) {
            System.out.println("재귀 함수 이용시 : " +
                    (recursive(arrN, i, 0, n - 1) > -1 ? "yes" : "no"));
            System.out.println("반복문 이용시 : " +
                    (loop(arrN, i, 0, n - 1) > -1 ? "yes" : "no"));
        }
    }

    // 재귀함수
    public static int recursive(int[] arr, int target, int start, int end){
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return recursive(arr, target, start, mid - 1);
        } else {
            return recursive(arr, target, mid + 1, end);
        }
    }

    // 반복문
    public static int loop(int[] arr, int target, int start, int end){
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
