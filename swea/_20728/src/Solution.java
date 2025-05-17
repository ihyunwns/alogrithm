import java.util.Arrays;
import java.util.Scanner;

/*
* SWEA | 20728. 공평한 분배 2 | D3
* https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&problemLevel=3&contestProbId=AY6cg0MKeVkDFAXt&categoryId=AY6cg0MKeVkDFAXt&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2
* */
public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int tc = 1; tc <= T; tc++) {

            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            long[] pocket = new long[N];
            input = sc.nextLine().split(" ");
            for(int i=0; i<N; i++) {
                pocket[i] = Integer.parseInt(input[i]);
            }

            // 오름차순 정렬
            Arrays.sort(pocket);
            //정렬해서 K개의 그룹으로 0~K, 1~K+1 .. 이렇게 그룹을 구한 뒤 최소값 비교
            long answer = Long.MAX_VALUE;
            for (int i = 0; i < N - K + 1; i++) {
                answer = Math.min(answer, pocket[i+K-1] - pocket[i]);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
