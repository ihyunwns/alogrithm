import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCases; tc++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);

            int[] taste = new int[N];
            int[] calorie = new int[N];

            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                taste[i] = Integer.parseInt(s[0]);
                calorie[i] = Integer.parseInt(s[1]);
            }

            int maxTaste = findMaxTaste(N, L, taste, calorie);
            System.out.println("#" + tc + " " + maxTaste);
        }
    }

    private static int findMaxTaste(int N, int L, int[] taste, int[] calorie) {
        int[] maxTasteValue = {0}; // 배열로 선언하여 dfs에서 값 갱신 가능하도록 함
        
        dfs(0, 0, 0, N, L, taste, calorie, maxTasteValue);
        return maxTasteValue[0];
    }

    private static void dfs(int depth, int totalTaste, int totalCalorie,
                            int N, int L,
                            int[] taste, int[] calorie, int[] maxTasteValue) {
        if (totalCalorie > L) return;  // 칼로리 초과

        maxTasteValue[0] = Math.max(maxTasteValue[0], totalTaste);  // 최대 맛 갱신

        // 가능한 모든 조합 생성
        for (int i = depth; i < N; i++) {
            dfs(i + 1,
                totalTaste + taste[i],      // 맛 누적
                totalCalorie + calorie[i],  // 칼로리 누적
                    N, L,
                taste, calorie, maxTasteValue);
        }
    }
}
