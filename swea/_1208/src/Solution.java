import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; ++tc) {
            int[] box = new int[100];

            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < 100; i++) {
                box[i] = Integer.parseInt(input[i]);
            }

            for (int i = 0; i < N; i++) {

                int[] heights = getHeight(box);
                int maxIdx = heights[2]; int minIdx = heights[3];

                if (heights[0] - heights[1] <= 1) {
                    // 평탄화 끝
                    break;
                } else {
                    // 평탄화
                    box[maxIdx]--;
                    box[minIdx]++;
                }
            }

            int[] finalHeights = getHeight(box);
            sb.append("#").append(tc).append(" ").append(finalHeights[0] - finalHeights[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static int[] getHeight(int[] box) {

        int highest = 0; int lowest = 100;
        int maxidx = 0; int minidx = 0;

        for (int i = 0; i < 100; i++) {
            if (box[i] > highest) {
                highest = box[i];
                maxidx = i;
            }
            if (box[i] < lowest) {
                lowest = box[i];
                minidx = i;
            }
        }

        return new int[] {highest, lowest, maxidx, minidx};

    }
}
