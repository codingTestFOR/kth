package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] indexApl = new int[26];

        for (int i = 0; i < indexApl.length; i++) {
            indexApl[i] = word.indexOf('a' + i);
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(indexApl[i]+" ");
        }
    }
}
