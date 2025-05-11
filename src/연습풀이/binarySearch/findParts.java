package 연습풀이.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class findParts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("n 입력 : ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("n 부품 번호 입력 : ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrN = new int[st.countTokens()];

        for (int i = 0; i < arrN.length; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);

        System.out.println("m 입력 : ");
        int m = Integer.parseInt(br.readLine());

        System.out.println("m 부품 번호 입력 : ");
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arrM = new int[st2.countTokens()];

        for (int i = 0; i < arrM.length; i++) {
            arrM[i] = Integer.parseInt(st2.nextToken());
        }



        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i : arrM) {
            bw.write(recursive(arrN, i, 0, n - 1) > -1 ? "yes " : "no ");
        }

        bw.flush();
        bw.close();
    }

    public static int recursive(int[] arr, int target, int start, int end){
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return recursive(arr, target, start, mid - 1);
        } else {
            return recursive(arr, target, mid + 1, end);
        }
    }
}
