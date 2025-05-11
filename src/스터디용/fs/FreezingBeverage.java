package 스터디용.fs;

import java.util.Scanner;

public class FreezingBeverage {
    public static int n, m;
    public static int[][] map;

    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (map[x][y] == 0) {
            map[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n m 입력 : ");
        n = scanner.nextInt();
        m = scanner.nextInt();

        System.out.println("틀 입력 : ");
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
