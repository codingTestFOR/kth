package 연습풀이.백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.contains("push")) {
                String[] arr = s.split(" ");
                int X = Integer.parseInt(arr[1]);
                Stack.push(X);
            } else if (s.equals("pop")) {
                int pop = Stack.pop();
                System.out.println(pop);
            }  else if (s.equals("size")) {
                int size = Stack.size();
                System.out.println(size);
            }  else if (s.equals("empty")) {
                int empty = Stack.empty();
                System.out.println(empty);
            }  else if (s.equals("top")) {
                int top = Stack.top();
                System.out.println(top);
            }

        }
    }

    static class Stack{
        static List<Integer> stack = new ArrayList<>();

        static void push(int X) {
            stack.add(X);
        }

        static int pop() {
            int result = -1;

            if (!stack.isEmpty()) {
                result = stack.remove(stack.size() - 1);
            }
            return result;
        }

        static int size() {
            return stack.size();
        }

        static int empty() {
            return stack.isEmpty() ? 1 : 0;
        }

        static int top() {
            return !stack.isEmpty() ? stack.get(stack.size()-1) : -1;
        }

    }
}
