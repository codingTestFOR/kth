package 스터디용.Implementation;

import java.util.Scanner;

public class StringCompress {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열 입력 : ");
        String s = scanner.nextLine();

        // 최종 출력길이
        int length = s.length();

        //logic
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            // 자를 문자열 개수를 i로
            String result = "";
            // 비교 문자열 선언 및 할당
            String prev = s.substring(0, i);
            // 압축 횟수
            int count = 1;

            // 현재 시작 위치를 j로
            for (int j = i; j < s.length(); j += i) {
                String current = "";
                // 문자열 추출 chatAt 사용을 위해 k 사용
                for (int k = j; k < j + i; k++) {
                    // k 길이 초과 방지
                    if (k < s.length()) {
                        current += s.charAt(k);
                    }
                }
                // 1 이전과 현재 문자열 비교
                if (prev.equals(current)) {
                    count++;
                // 2 압축 종료
                } else {
                    // 압축된 경우 결과 문자열에 숫자와 더해 결합
                    result += (count > 1) ? count + prev : prev;
                    // 바뀐 문자열로 비교군 수정
                    prev = current;
                    // 카운트 초기화
                    count = 1;
                }
            }
            // 압축 루프 종료 이후 모든 문자열 result에 결합
            result += (count > 1) ? count + prev : prev;
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답(인텔리제이에서 삼항 연산자 > min 변경 추천)
            length = (length < result.length()) ? length : result.length();
//            length = Math.min(length, result.length());
        }
        System.out.println("length = " + length);
    }
}
