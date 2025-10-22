package 연습풀이.백준.자료구조;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            index = (index + k - 1) % list.size();
            int result = list.remove(index);
            bw.write((i < n-1) ? result + ", " : result + ">");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
