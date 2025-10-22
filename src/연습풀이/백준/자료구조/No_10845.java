package 연습풀이.백준.자료구조;

import java.io.*;

public class No_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue queue = new Queue();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            switch (input.split(" ")[0]) {
                case "push":
                    int X = Integer.parseInt(input.split(" ")[1]);
                    queue.push(X);
                    break;
                case "pop":
                    bw.write(queue.pop() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write(queue.empty() + "\n");
                    break;
                case "front":
                    bw.write(queue.front() + "\n");
                    break;
                case "back":
                    bw.write(queue.back() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Queue {

        int[] arr;
        int start;
        int end;

        public Queue() {
            arr = new int[10000];
            start = 0;
            end = -1;
        }

        void push(int X) {
            arr[++end] = X;
        }

        int pop() {
            return (start > end) ? -1 : arr[start++];
        }

        int size() {
            return (start > end) ? 0 : end - start + 1;
        }

        int empty() {
            return (start > end) ? 1 : 0;
        }

        int front() {
            return (start > end) ? -1 : arr[start];
        }

        int back() {
            return (start > end) ? -1 : arr[end];
        }
    }

}
