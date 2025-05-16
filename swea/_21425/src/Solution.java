
/*
* SWEA | 21425. += | D2
* https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&problemLevel=3&contestProbId=AZD8K_UayDoDFAVs&categoryId=AZD8K_UayDoDFAVs&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
* */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int tc=1;tc<=T;tc++){
            String[] input = sc.nextLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]);

            /*
            * A와 B 중 작은쪽으로 더하는 게 맞음
              예를 들어 A=3, B=10 일때
              A += B 를 해야 다음에 더 큰 값을 얻을 수 있음
              예시를 들어보면
              1) A += B => A = 3 + 10 = 13, B = 10

              2) B += A => B = 10 + 3 = 13, A = 3

            * 1번의 경우 다음 연산으로 갔을 때
            * A += B => A = 13 + 10 = 23 을 얻을 수 있지만
            *
            * 2번의 경우로 갔을 때는
            * A += B => A = 3 + 13 = 16 을 얻을 수 있음
            *
            * 따라서 각각의 연산을 수행할 때 좀 더 작은쪽으로 더하도록 하는게 핵심
            *
            * */

            int count = 0;
            do {
                count++;
                if (A > B) {
                    B += A;
                } else {
                    A += B;
                }
            } while (A <= N && B <= N);

            System.out.println(count);

        }
    }
}
