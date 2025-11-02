package 연습풀이.백준.자료구조;

import java.io.*;
import java.util.*;

public class No_2263 {
    static int n;
    static int[] inorder, postorder, index;

    static StringBuilder sb = new StringBuilder();

    static void build(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIdx = index[root];
        int leftSize = rootIdx - inStart;

        build(inStart, rootIdx - 1, postStart, postStart + leftSize - 1); // 왼쪽
        build(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);     // 오른쪽
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inorder = new int[n + 1];
        postorder = new int[n + 1];
        index = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) inorder[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) postorder[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) index[inorder[i]] = i;

        build(1, n, 1, n);
        System.out.println(sb);
    }
}
