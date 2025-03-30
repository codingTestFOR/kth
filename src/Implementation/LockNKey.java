package Implementation;

import java.util.Scanner;

public class LockNKey {
    // 회전 메소드
    public static int[][] rotateQuarter(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        System.out.println("키 배열 입력 : ");
        String inputKey = scanner.nextLine();
        System.out.println("자물쇠 배열 입력 : ");
        String inputLock = scanner.nextLine();

        int[][] keyArr = extracted(inputKey);
        int[][] lockArr = extracted(inputLock);

        //logic
        boolean result = false;
        int n = lockArr.length;
        int m = keyArr.length;
        // 3배수 자물쇠 선언
        int[][] newLockArr = new int[3 * n][3 * n];
        // 기존 자물쇠 중앙 할당
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLockArr[i + n][j + n] = lockArr[i][j];
            }
        }

        // 열쇠 회전 루프
        for (int dir = 0; dir < 4; dir++) {
            keyArr = rotateQuarter(keyArr);
            // 1 x,y는 탐색의 끝점
            for (int x = 0; x < 2 * n; x++) {
                for (int y = 0; y < 2 * n; y++) {
                    // 자물쇠 + 열쇠
                    // 2 i, j는 각 행렬 요소
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLockArr[x + i][y + j] += keyArr[i][j];
                        }
                    }

                    // 해제 여부 검사
                    if (check(n, newLockArr)) {
                        result = true;
                        System.out.println("result = " + result);
                        return;
                    }
                    // 자물쇠 초기화(! 깊은 복사 사용시 메모리 사용량?)
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLockArr[x + i][y + j] -= keyArr[i][j];
                        }
                    }
                }
            }
        }
    }

    private static boolean check(int n, int[][] newLockArr) {
        for (int t = n; t < 2 * n; t++) {
            for (int s = n; s < 2 * n; s++) {
                if (newLockArr[t][s] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] extracted(String inputKey) {
        String sKey = inputKey.replace("[[", "")
                .replace("]]", "")
                .replace("[", "");

        String[] rowsKey = sKey.split("],");

        int[][] keyArr = new int[rowsKey.length][];
        for (int i = 0; i < rowsKey.length; i++) {
            String[] elements = rowsKey[i].split(",");
            keyArr[i] = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                keyArr[i][j] = Integer.parseInt(elements[j].trim());
            }
        }
        return keyArr;
    }
}
