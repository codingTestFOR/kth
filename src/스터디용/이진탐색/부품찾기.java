package 스터디용.이진탐색;

import java.io.*;
import java.util.*;

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
        for (int i = 1; i < m+1; i++) {
            arrM[i] = sc.nextInt();
        }

        for (int i = 1; i < m+1; i++) {
            System.out.println("재귀 함수 이용시 : " +
                    (recursive(arrN, i, 0, n - 1) > -1 ? "yes" : "no"));
            System.out.println("-------------");
            System.out.println("반복문 이용시 : " +
                    (loop(arrN, i, 0, n - 1) > -1 ? "yes" : "no"));
            System.out.println("-------------");
        }

        countingSort(arrN, arrM);
        System.out.println("-------------");
        set(arrN, arrM);
    }
    // 재귀함수
    public static int recursive(int[] arr, int target, int start, int end){
        // 탈출 조건
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

    //계수정렬
    public static void countingSort(int[] arrN, int[] arrM){
        int[] table = new int[arrN[arrN.length - 1] + 1];
        for (int i : arrN) {
            table[i] = 1;
        }

        for (int i = 1; i < arrM.length; i++ ) {
            if (table[i] == 1) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }


    //집합
    public static void set(int[] arrN, int[] arrM){
         Set<Integer> set = new HashSet<>();
         for (int num : arrN) {
             set.add(num);
         }

        for (int i = 1; i < arrM.length; i++ ) {
            if (set.contains(arrM[i])) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }
}
