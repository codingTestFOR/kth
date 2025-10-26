package 연습풀이.백준.자료구조;

import java.io.*;
import java.util.*;

public class No_10866 {
    static int[] deque = new int[20000];
    static int front = 10000;
    static int back = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("push_front")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                deque[--front] = x;
            }
            else if (cmd.startsWith("push_back")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                deque[back++] = x;
            }
            else if (cmd.equals("pop_front")) {
                if (front == back) sb.append(-1).append('\n');
                else sb.append(deque[front++]).append('\n');
            }
            else if (cmd.equals("pop_back")) {
                if (front == back) sb.append(-1).append('\n');
                else sb.append(deque[--back]).append('\n');
            }
            else if (cmd.equals("size")) {
                sb.append(back - front).append('\n');
            }
            else if (cmd.equals("empty")) {
                sb.append(front == back ? 1 : 0).append('\n');
            }
            else if (cmd.equals("front")) {
                sb.append(front == back ? -1 : deque[front]).append('\n');
            }
            else if (cmd.equals("back")) {
                sb.append(front == back ? -1 : deque[back - 1]).append('\n');
            }
        }

        System.out.print(sb);
    }
}
