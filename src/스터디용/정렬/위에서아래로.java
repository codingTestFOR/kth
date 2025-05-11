package 스터디용.정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 위에서아래로 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n 입력 받기
        System.out.println("n 입력 : ");
        int n = scanner.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 스터디용.정렬

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

        /*
        Arrays.sort의 스터디용.정렬 알고리즘은
        Dual-Pivot QuickSort를 사용 (시간복잡도 nlogn, 최악 n^2)

        Dual-Pivot QuickSort는 피벗을 두 개 사용하는 퀵소트
         */
    }
}
