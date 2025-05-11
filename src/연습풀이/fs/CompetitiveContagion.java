        package 연습풀이.fs;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;


        /*
            DFS 사용 불가 이유
            1. 시간별 동시 확산 불가
            2. 스택 기반이라 우선 순위 보장 불가
         */
        public class CompetitiveContagion {
            public static int n, k, s, x, y;
            public static int[][] map;
            public static int[] dx = {1, 0, -1, 0 };
            public static int[] dy = {0, 1, 0, -1};

            public static List<int[]> virus = new ArrayList<>();


            public static void main(String[] args) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("n k 입력 : ");
                StringTokenizer st = null;
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                n = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                map = new int[n][n];
                for (int i = 0; i < n; i++) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    for (int j = 0; j < n; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                System.out.println("s x y 입력 : ");
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                s = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                // 입력 확인
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(map[i][j] + " ");
                    }
                    System.out.println();
                }

                int[][] virusArr = virus(s);
                int result = virusArr[x-1][y-1];
                System.out.println(Math.max(result, 0));

            }

            public static int[][] virus(int s){
                int count = 0;
                while (count != s) {
                    // 낮은 바이러스부터 전염
                    for (int m = 1; m < k + 1; m++) {

                        int x = -1;
                        int y = -1;
                        int nx = -1;
                        int ny = -1;
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (map[i][j] == m) {
                                    x = i;
                                    y = j;
                                }
                            }
                        }

                        for (int i = 0; i < 4; i++) {
                            nx = x + dx[i];
                            ny = y + dy[i];

                            if (x >= 0 && x < n && y >= 0 && y < n) {
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                    if (map[nx][ny] == 0) {
                                        map[nx][ny] = m;
                                    }
                                }
                            }
                        }
                    }
                    count++;
                }
                return map;
            }
        }
