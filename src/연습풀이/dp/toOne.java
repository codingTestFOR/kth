package 연습풀이.dp;

import java.util.Scanner;

public class toOne {

    static int[] memo = new int[30001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("x 입력 : ");
        int x = scanner.nextInt();

        long startTime = System.nanoTime();
        System.out.println(operation(x));
        long endTime = System.nanoTime();

        System.out.println("1 소요시간 : "+ (endTime-startTime));

        long startTime2 = System.nanoTime();
        System.out.println(minOperations(x));
        long endTime2 = System.nanoTime();

        System.out.println("2 소요시간 : "+ (endTime2-startTime2));

    }

    public static int operation(int x) {
        if (x == 1) {
            return 0;
        }

        int result = operation(x - 1);

        if (x % 2 == 0) {
            result = Math.min(result, operation(x / 2));
        }
        if (x % 3 == 0) {
            result = Math.min(result, operation(x / 3));
        }
        if (x % 5 == 0) {
            result = Math.min(result, operation(x / 5));
        }

        return result + 1;
    }

    public static int minOperations(int x) {
        if (x == 1) return 0;
        if (memo[x] != 0) return memo[x];

        int result = minOperations(x - 1);
        if (x % 2 == 0) result = Math.min(result, minOperations(x / 2));
        if (x % 3 == 0) result = Math.min(result, minOperations(x / 3));
        if (x % 5 == 0) result = Math.min(result, minOperations(x / 5));

        return memo[x] = result + 1;
    }


}
