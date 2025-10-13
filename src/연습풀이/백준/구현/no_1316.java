package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class no_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();

            sb.append(str.charAt(0));
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j-1) != str.charAt(j)) {
                    sb.append(str.charAt(j));
                }
            }

            StringBuilder sb2 = new StringBuilder();
            Set<Character> set = new LinkedHashSet<>();

            for (char c : str.toCharArray()) {
                set.add(c);
            }

            for (char c : set) {
                sb2.append(c);
            }

            if (sb.toString().equals(sb2.toString())) count++;
        }


        System.out.println(count);
    }
}
