package dp;

import java.util.Scanner;

public class _1로만들기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("x 입력 : ");
        int x = scanner.nextInt();

        long startTime = System.nanoTime();
        System.out.println(operation(x));
        long endTime = System.nanoTime();

        System.out.println("소요시간 : "+ (endTime-startTime));

    }

    public static int operation(int x){
        // dp table 생성 > 바텀업 방식
        int[] table = new int[x + 1];

        for (int i = 2; i < x + 1; i++) {
            // 기본적으로 바로 이전 테이블의 값(최소 연산 횟수) + 1 할당
            table[i] = table[i - 1] + 1;
            // 할당 이후 조건별 최소가 변경될 경우 값을 재할당
            if (i % 5 == 0) {
                table[i] = Math.min(table[i / 5] + 1, table[i]);
            }
            if (i % 3 == 0) {
                table[i] = Math.min(table[i / 3] + 1, table[i]);
            }
            if (i % 2 == 0) {
                table[i] = Math.min(table[i / 2] + 1, table[i]);
            }
        }

        return table[x];
    }

    /*
    정석 풀이 209600

    재귀 풀이 360000
    재귀 + 메모 풀이 62400
     */
}
