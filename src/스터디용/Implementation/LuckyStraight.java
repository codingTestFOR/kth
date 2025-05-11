package 스터디용.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyStraight {

    static String N;
    static List<Integer> list = new ArrayList<>();
    // 추가 풀이용
    static int n;
    static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {
        // 입력 방식 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 입력 : ");
        N = scanner.nextLine();

        // Sting input > char(아스키)
        for (char c : N.toCharArray()) {
            list.add(c - '0');
        }

//        // 입력 방식 2
//        scanner.nextInt();
//        System.out.println("숫자 입력 : ");
//        n = scanner.nextInt();
//
//        // 모듈러 연산 활용시 순서 주의
//        while (n > 0) {
//            list2.add(0, n % 10);
//            n /= 10;
//        }

        // stream 사용
        int size = list.size();
        int sum1 = list.subList(0, size/2).stream()
                .mapToInt(Integer::intValue)
                .sum();
        int sum2 = list.subList(size/2, size).stream()
                .mapToInt(Integer::intValue)
                .sum();
//       // 기본 문법 코드
//        int size = list.size();
//        int sum1 = 0;
//        int sum2 = 0;
//
//        int mid = size / 2;
//
//        for (int i = 0; i < mid; i++) {
//            sum1 += list.get(i);
//        }
//
//        for (int i = mid; i < size; i++) {
//            sum2 += list.get(i);
//        }

        if (sum1 == sum2) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
