package 연습풀이;

import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 참가자 수 입력
        System.out.print("참가자 수를 입력하세요: ");
        int width = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        // 참가자 이름 입력
        String[] participants = new String[width];
        for (int i = 0; i < width; i++) {
            System.out.print("참가자 " + (i + 1) + " 이름을 입력하세요: ");
            participants[i] = scanner.nextLine();
        }

        int height = 10;
        boolean[][] ladder = new boolean[height][width - 1]; // 가로선 존재 여부

        Random random = new Random();

        // 랜덤으로 가로선 생성 (인접한 가로선이 겹치지 않도록)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width - 1; j++) {
                if (j > 0 && ladder[i][j - 1]) {
                    ladder[i][j] = false; // 인접 가로선 방지
                } else {
                    ladder[i][j] = random.nextBoolean();
                }
            }
        }

        // 결과 계산
        int[] positions = new int[width];
        for (int i = 0; i < width; i++) {
            positions[i] = i;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width - 1; j++) {
                if (ladder[i][j]) {
                    int temp = positions[j];
                    positions[j] = positions[j + 1];
                    positions[j + 1] = temp;
                }
            }
        }

        // 사다리 출력 (참가자 이름 윗부분)
        System.out.print(" ");
        for (String p : participants) {
            System.out.print(" " + p + "  ");
        }
        System.out.println();

        // 사다리 모양 출력
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width - 1; j++) {
                if (ladder[i][j]) {
                    System.out.print("---|");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();
        }

        // 결과 위치별 참가자 이름 배열 생성
        String[] resultToParticipant = new String[width];
        for (int i = 0; i < width; i++) {
            resultToParticipant[positions[i]] = participants[i];
        }

        // 사다리 마지막 줄 아래에 결과 위치별 참가자 이름 출력
        System.out.print(" ");
        for (String name : resultToParticipant) {
            // 이름 길이에 따라 간격 조절 (기본 4칸 확보)
            int spaceCount = 4 - name.length();
            if (spaceCount < 1) spaceCount = 1;
            System.out.print(" " + name);
            for (int s = 0; s < spaceCount; s++) {
                System.out.print(" ");
            }
        }
        System.out.println();

        scanner.close();
    }
}