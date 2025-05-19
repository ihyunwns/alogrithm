import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int answer;  // 정답을 저장할 변수 추가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            answer = 0;  // 테스트케이스마다 초기화
            dfs(0, new boolean[N][N], N);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void dfs(int depth, boolean[][] board, int N) {
        if (depth >= N) {
            answer++;  // 성공적으로 N개의 퀸을 놓았을 때 답 증가
            return;
        }

        for (int col = 0; col < N; col++) {  // 열을 기준으로 순회
            // 현재 행(depth)의 각 열에 퀸을 놓아봄
            if (isPossible(board, depth, col)) {  // 현재 위치가 가능한지 확인
                board[depth][col] = true;  // 퀸 배치
                dfs(depth + 1, board, N);
                board[depth][col] = false;  // 백트래킹
            }
        }
    }

    private static boolean isPossible(boolean[][] board, int x, int y) {
        int N = board.length;

        // 같은 열 검사
        for (int i = 0; i < x; i++) {
            if (board[i][y]) return false;
        }

        // 왼쪽 위 대각선 검사
        for (int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        // 오른쪽 위 대각선 검사
        for (int i = x-1, j = y+1; i >= 0 && j < N; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }
}