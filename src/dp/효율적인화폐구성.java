package dp;

import java.util.Arrays;
import java.util.Scanner;

public class 효율적인화폐구성 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n m 입력 : ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println("종류 입력 : ");
        int[] type = new int[n + 1];

        // 화폐 종류 type arr 입력
        for (int i = 0; i < n; i++) {
            type[i] = scanner.nextInt();
        }


        // dp table 생성 > 바텀업 방식
        int[] table = new int[m + 1];
        // dp table 모든 요소 20000으로 초기화
        Arrays.fill(table, 20000);

        // 0번째 요소 0 할당
        table[0] = 0;
        // 화폐 종류별로 dp table 갱신
        for (int i = 0; i < n; i++) {
            // 화폐 순서대로 화폐 크기 ~ 전체 값 m 까지 루프
            for (int j = type[i]; j < m + 1; j++) {
                table[j] = Math.min(table[j - type[i]] + 1, table[j]);
            }
        }

        System.out.println(table[m] != 20000 ? table[m] : -1);
    }
}
