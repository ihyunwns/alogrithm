import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); // N일 동안의 물건의 매매가를 알 수 있음

            long[] prices = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Long.parseLong(st.nextToken());
            }

            long maxProfit = 0;
            long maxPrice = prices[N-1]; // 마지막 날의 가격을 최대값으로 초기화

            // 뒤에서부터 순회
            for (int i = N-2; i >= 0; i--) {
                if (prices[i] <= maxPrice) {
                    // 현재 가격이 최대 가격보다 작거나 같으면 이익 계산, 그때 그때 이익을 계산하는 것
                    maxProfit += maxPrice - prices[i];
                } else {
                    // 현재 가격이 더 크면 최대 가격 갱신
                    maxPrice = prices[i];
                }
            }

            System.out.println("#" + tc + " " + maxProfit);

        }
    }
}
