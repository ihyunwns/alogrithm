import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /*
    문제 설명
    rows x columns 크기인 행렬이 있습니다. 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다.
    이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다.
    각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.
    x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
    * */

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));
    }
}

class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, 10000);
        int[][] matrix = new int[rows][columns];

        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = n++;
            }
        }

        int[] move = {1, -1};
        for (int i = 0; i < queries.length; i++) {
            int[] pos = {queries[i][0], queries[i][1]};
            int dx = Math.abs(queries[i][0] - queries[i][2])+1;
            int dy = Math.abs(queries[i][1] - queries[i][3])+1;

            List<int[]> sequence = new ArrayList<>();

            // y 증가 > x 증가 > y 감소 > x 감소
            for (int j = 0; j < 2; j++) {
                for (int y = 1; y < dy; y++) {
                    sequence.add(new int[]{pos[0], pos[1]});
                    pos[1] += move[j];
                }
                for (int x = 1; x < dx; x++) {
                    sequence.add(new int[]{pos[0], pos[1]});
                    pos[0] += move[j];
                }
            }

            // 이렇게 temp 배열을 만들지 않고 거꾸로 접근해서 matrix를 바꿔주는 방법도 있음
            /* ex)
               1  2  3  4  5
               6           10
               11 12 13 14 15
               테두리가 이렇게 있다고 할 때 5>1 쪽으로 이동하는 방식
               5=>4 > 4=>3 > 3=>2 > 2=>1
            * */
            int[] temp = new int[sequence.size()];
            for (int k = 0; k < sequence.size(); k++) {
                temp[k] = matrix[sequence.get(k)[0]-1][sequence.get(k)[1]-1];
                answer[i] = Math.min(answer[i], temp[k]);
            }
            for (int cur = 0; cur < sequence.size(); cur++) {
                int next = cur+1;
                if (next > sequence.size() -1 ) {
                    next = 0;
                }
                int nx = sequence.get(next)[0];
                int ny = sequence.get(next)[1];

                matrix[nx - 1][ny - 1] = temp[cur];
            }
        }

        return answer;
    }
}