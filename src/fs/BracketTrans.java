package fs;

import java.util.Scanner;

public class BracketTrans {
    // 균형
    public static int retIndex(String bracket){
        int count = 0;

        for (int i = 0; i < bracket.length(); i++) {
            bracket.charAt(i);
            if (bracket.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                return i;
            }
        }
        return 0;
    }

    // 올바른
    public static boolean retYn(String bracket) {
        int count = 0;
        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return true;
    }

    public static String flip(String bracket) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                builder.append(')');
            } else {
                builder.append('(');
            }
        }
        return builder.toString();
    }

    public static String solution(String bracket){
        StringBuilder builder = new StringBuilder();
        // 시작

        // 단계1 빈 문자열
        if (bracket.isEmpty()) {
            return "";
        }

        // 단계2
        int i = retIndex(bracket);
        String u = bracket.substring(0,i+1);
        String v = bracket.substring(i+1);

        // 단계3
        if (retYn(u)) {
            // 3-1
            return u + solution(v);
        } else {
            // 단계4
            // 4-1
            builder.append("(");
            // 4-2
            builder.append(solution(v));
            // 4-3
            builder.append(")");
            // 4-4
            String nu = u.substring(1, u.length() - 1);
            builder.append(flip(nu));
        }
        return builder.toString();
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("괄호 입력 : ");
        String bracket = scanner.nextLine();

        System.out.println(solution(bracket));
    }
}
