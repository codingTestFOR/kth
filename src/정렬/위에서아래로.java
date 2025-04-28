package 정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
