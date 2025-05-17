import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
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
                    // i가 틀렸으면 0~i 번째의 값들도 전치됨 하지만 그 값들은 정해져있으므로 해당 값에 따라서 실제 정렬할 필요 없이 전치되면
                    // 어떤 값이 올지 알 수 있음
                    for (int j = 0; j <= i; j++) {
                        if (matrix[0][j] == j + 1) {
                            // (행 - 1) x N + 열
                            matrix[0][j] = j * N + 1;
                        } else {
                            matrix[0][j] = j + 1;
                        }
                    }
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
