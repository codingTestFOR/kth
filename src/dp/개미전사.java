package dp;

import java.util.Scanner;

public class 개미전사 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n 입력 : ");
        int n = scanner.nextInt();

        System.out.println("창고 입력 : ");
        int[] storage = new int[n + 1];

        for (int i = 0; i < n; i++) {
            storage[i + 1] = scanner.nextInt();
        }

        // dp table 생성 > 바텀업 방식
        int[] table = new int[n + 1];

        // dp table 1, 2 초기화
        table[1] = storage[1];
        table[2] = Math.max(storage[1], storage[2]);

        // 3부터는 점화식 이용
        for (int i = 3; i < n + 1; i++) {
            table[i] = Math.max(table[i - 1], table[i - 2] + storage[i]);
        }

        System.out.println(table[n]);
    }
}
