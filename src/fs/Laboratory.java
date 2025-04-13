package fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Laboratory {
    public static int n, m;
    public static int[][] map;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("n m 입력 : ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        System.out.println("맵 입력 : ");
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(map));
    }

    public static int solution(int[][] map) {
        // 안전구역 최대 개수
        int result = 0;
        List<int[]> zeroList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    // 0인 위치를 배열로 기록
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        // 벽 세우기(3중 배열을 통해 모든 경우의 수 루프, 해답은 백 트래킹 사용)
        for (int i = 0; i < zeroList.size(); i++) {
            for (int j = i + 1; j < zeroList.size(); j++) {
                for (int k = j + 1; k < zeroList.size(); k++) {
                    int[] first = zeroList.get(i);
                    int[] second = zeroList.get(j);
                    int[] third = zeroList.get(k);

                    // 벽 세우기 끝
                    int[][] newMap = deepCopy(map);
                    newMap[first[0]][first[1]] = 1;
                    newMap[second[0]][second[1]] = 1;
                    newMap[third[0]][third[1]] = 1;

                    // 바이러스 퍼뜨리기
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < m; y++) {
                            if (newMap[x][y] == 2) {
                                dfs(newMap, x, y);
                            }
                        }
                    }

                    // 벽이 세워진 공간의 안전 구역 카운트
                    int count = zeroCount(newMap);
                    // 최대값 교체
                    result = Math.max(result, count);
                }
            }
        }

        return result;
    }

    public static void dfs(int[][] map, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    dfs(map, nx, ny);
                }
            }
        }
    }

    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    public static int zeroCount(int[][] map) {
        int count = 0;
        for (int[] row : map) {
            for (int val : row) {
                if (val == 0) count++;
            }
        }
        return count;
    }
}
