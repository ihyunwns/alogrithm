import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine()); // 건물의 개수 N

            int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int count = 0;
            for(int i=2; i<N-2; i++){
                // 현재 건물의 양옆 두칸 건물의 높이 중 최대값을 가지는 건물의 높이를 구함
                int max_height = Math.max(Math.max(height[i - 2], height[i - 1]), Math.max(height[i + 1], height[i + 2]));
                if (max_height < height[i]) {
                    count += height[i] - max_height;
                }
            }

            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }

        System.out.println(sb);

    }
}
