package 연습풀이.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Double> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            list.add(Double.parseDouble(st.nextToken()));
        }

        double sum = 0;
        double max = -1;

        for (Double d : list) {
            if (d >= max) max = d;
            sum += d;
        }

        System.out.println((sum / N) / max * 100);


    }
}
