package 스터디용.Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("입력 : ");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();


        int value = 0;
        List<String> list = new ArrayList<>();

        // 값 확인
        for (char x : chars) {
            if (Character.isLetter(x)) {
                String c = String.valueOf(x);
                list.add(c);
            } else if (Character.isDigit(x)) {
                value += x-'0';
            }
        }

        Collections.sort(list);
        System.out.println(String.join("",list)+""+value);
    }
}
