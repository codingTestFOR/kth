package 연습풀이.예제;

import java.util.Arrays;
import java.util.Scanner;

public class 문자열재정렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        StringBuilder left = new StringBuilder();
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A') {
                left.append(s.charAt(i));
            } else right += s.charAt(i) - '0';
        }

        char[] chars = left.toString().toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        System.out.println(sorted+right);
    }
}
