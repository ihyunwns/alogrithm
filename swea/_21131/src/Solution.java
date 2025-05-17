
/*
* SWEA | 21131. 행렬정렬 | D3
* https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&problemLevel=3&contestProbId=AZCQ28pKbaQDFAUC&categoryId=AZCQ28pKbaQDFAUC&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
* */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();


        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            sc.nextLine();
            int[][] matrix = new int[N][N];

            for(int i=0; i<N; i++) {
                String[] str = sc.nextLine().split(" ");
                for(int j=0; j<N; j++) {
                    matrix[i][j] = Integer.parseInt(str[j]);
                }
            }

            int count = 0;
            for(int i=N-1; i>=0; i--) {
                if (i + 1 != matrix[0][i]) {
                    transpose(matrix, i);
                    count++;
                }
            }

            System.out.println(count);

        }

        // 전치 행렬은 대각선축을 기준으로 위치를 바꾼 행렬
        // [i][j] <-> [j][i]

        // 정렬 가능한 행렬이 주어지므로 뭔가 행렬에 규칙성이 있을 것 같음
        // 행렬이 nxn 사이즈의 정사각형 비율로만 섞여있음, 전치로만 정렬이 되도록
        // 만약 맨 윗줄이 1 2 11 4 21 인 경우 맞지 않는 위치에 있는 숫자는 11과 21이므로 가장 바깥 열에 있는 21을 기준으로 정렬을 시작하면 됨.
        // 여기서 맨 윗줄만 보는 이유는 정사각형 비율로 일정하게 섞여있어서 맨윗줄에 따라서 해당 값 기준 사각형 범위의 가장자리 들은 다 섞여있음
        // 그렇게 정렬을 하면 1 6 3 16 5 이렇게 바뀌게 될 것임 여기서 다시 6, 16이 제자리에 있지 않으므로 가장 바깥에 있는 열인 16을 기준으로 정렬..
        // 이를 반복하면 정렬이 마무리가 됨

        sc.close();

    }

    static void transpose(int[][] matrix, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
