package 스터디용.dp;

import java.util.Scanner;

public class 바닥공사 {
    static int[] memo = new int[1001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n 입력 : ");
        int n = scanner.nextInt();

        // 스터디용.dp table 생성 > 바텀업 방식
        int[] table = new int[n + 1];
        table[1] = 1;
        table[2] = 3;
        // 점화식 사용
        for (int i = 3; i < n + 1; i++) {
            table[i] = table[i - 1] + 2 * table[i - 2];
        }

        System.out.println("bottomUp : "+ table[n] % 796796);
        System.out.println("topDown : "+ topDown(n) % 796796);
    }

    public static int topDown(int n){
        // 여기까진 동일
        int[] table = new int[n + 1];
        memo[1] = 1;
        memo[2] = 3;

        // 여기부터 재귀 + 메모 사용
        if (memo[n] != 0) {
            return memo[n];
        }

        // 메모가 없는 경우 점화식대로 값 입력
        memo[n] = topDown(n - 1) + 2 * topDown(n - 2);

        return memo[n];

    }
}
