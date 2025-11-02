package 연습풀이.백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No_1991 {
    static class Node {
        char left, right;
        Node(char l, char r) {
            this.left = l;
            this.right = r;
        }
    }

    static HashMap<Character, Node> tree = new HashMap<>();

    static void preorder(char root) {
        if (root == '.') return;
        System.out.print(root);
        preorder(tree.get(root).left);
        preorder(tree.get(root).right);
    }

    static void inorder(char root) {
        if (root == '.') return;
        inorder(tree.get(root).left);
        System.out.print(root);
        inorder(tree.get(root).right);
    }

    static void postorder(char root) {
        if (root == '.') return;
        postorder(tree.get(root).left);
        postorder(tree.get(root).right);
        System.out.print(root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.put(root, new Node(left, right));
        }

        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');
    }
}