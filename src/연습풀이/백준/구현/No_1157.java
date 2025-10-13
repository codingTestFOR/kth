package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] visited = new int[26];
        int max = 0;
        int maxIndex = -1;
        int dupCount = 0;
        String wordToLower = word.toLowerCase();
        for (int i = 0; i < wordToLower.length(); i++) {
            char c = wordToLower.charAt(i);
            visited[c - 'a']++;
        }

        for (int i = 0; i < visited.length; i++){
            if (visited[i] > max) {
                max = visited[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < visited.length; i++){
            if (visited[i] == max) {
                dupCount++;
            }
        }

        if (dupCount > 1){
            System.out.println('?');
        } else {
            System.out.println((char) (maxIndex + 'A'));
        }

    }
}
