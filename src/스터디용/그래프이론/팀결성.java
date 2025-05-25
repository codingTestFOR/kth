package 스터디용.그래프이론;

import java.util.Scanner;

public class 팀결성 {
    static int[] parent;

    // find 연산
    public static int findParent(int x) {
        // 경로 압축을 사용(부모 테이블을 갱신하는 과정으로 최초 find 연산 이후의 성능을 개선)
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    // union 연산
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n m 입력 : ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];

        // 부모테이블 초가화(초기값 자기 자신)
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        System.out.println("연산 입력 : ");
        for (int i = 0; i < m; i++) {
            int oper = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (oper == 0) {
                unionParent(a, b);
            } else if (oper == 1) {
                if (findParent(a) == findParent(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
