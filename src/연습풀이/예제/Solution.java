package 연습풀이.예제;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {int sum = 0;
            for(int i = 0; i<10 ; i++){
                int temp = sc.nextInt();
                if (temp % 2 == 1) {
                    sum += temp;
                }
            }


            System.out.println("#" + test_case + " " + sum);
        }
    }
}