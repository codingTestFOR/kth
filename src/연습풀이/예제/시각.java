package 연습풀이.예제;

import java.util.Scanner;

public class 시각 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n 입력 받기
        System.out.println("n 입력 : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int count = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String time = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if (time.contains("3")) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
