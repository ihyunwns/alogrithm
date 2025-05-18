import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            int x = 0;
            int y = 0;
            int n = 1;

            // y축 연산이 끝나면 -1
            int x_border = N;

            // x축 연산이 끝나면 -1
            int y_border = N;

            while (n <= N * N) {

                // X축 증가
                for (int px = 0; px < x_border; px++) {
                    if (arr[y][x] == 0) {
                        arr[y][x] = n;
                        x++;
                        n++;
                    }
                }

                x--;
                y++; // 한칸 아래로
                y_border--;

                // Y축 감소 ( 배열에선 증가 )
                for (int py = 0; py < y_border; py++) {
                    if (arr[y][x] == 0) {
                        arr[y][x] = n;
                        y++;
                        n++;
                    }
                }

                y--;
                x--; // 한칸 왼쪽으로
                x_border--;

                // X축 감소
                for (int px = 0; px < x_border; px++) {
                    if (arr[y][x] == 0) {
                        arr[y][x] = n;
                        x--;
                        n++;
                    }
                }
                x++;
                y--; // 한칸 위로
                y_border--;

                // Y축 증가
                for (int py = 0; py < y_border; py++) {
                    if (arr[y][x] == 0) {
                        arr[y][x] = n;
                        y--;
                        n++;
                    }
                }
                y++;
                x++; // 한칸 오른쪽으로
                x_border--;

            }

            System.out.println("#" + i);
            for(int[] row : arr){
                for(int col : row){
                    System.out.print(col + " ");
                }
                System.out.println(" ");
            }
        }


    }
}
