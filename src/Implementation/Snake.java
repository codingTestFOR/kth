package Implementation;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake {
    public static int n, apple, l;
    public static int[][] arr = new int[100][100];
    public static List<info> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n 입력 :");
        n = scanner.nextInt();
        System.out.println("사과 개수 입력 :");
        apple = scanner.nextInt();

        System.out.println("사과 위치 입력 :");
        for (int i = 0; i < apple; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[a][b] = 1;
        }

        System.out.println("전환 횟수 입력 :");
        int l = scanner.nextInt();

        System.out.println("시간 및 방향 입력 :");
        for (int i = 0; i < l; i++) {
            int a = scanner.nextInt();
            char b = scanner.next().charAt(0);
            list.add(new info(a, b));
        }

        System.out.println(list);

    }
}

@ToString
class info {
    int time;
    char dir;

    public info(int time, char dir) {
        this.time = time;
        this.dir = dir;
    }

    public int getTime() {
        return time;
    }

    public char getDir() {
        return dir;
    }
}
