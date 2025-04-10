import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /* https://www.acmicpc.net/problem/1365 */
    // Difficulty: GOLD 2

    /* 수열이 이전 숫자보다 줄어들게 되면 꼬임이 발생하게 된다 즉 오름 차순을 가지는 수열을 구하는게 핵심
    * 그 중 최소한의 전깃줄만 잘라야 하니 최장 길이의 오름 차순 수열을 구하면 문제를 풀 수 있음
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count_pole = Integer.parseInt(br.readLine());
        int[] poles = new int[count_pole];

        String[] lines = br.readLine().split(" ");
        for (int i = 0; i < count_pole; i++) {
            poles[i] = Integer.parseInt(lines[i]);
        }

        List<Integer> list = new ArrayList<>();
        list.add(poles[0]);
        for (int i = 1; i < count_pole; i++) {
            // 현재 순회 숫자가 list 배열의 마지막 값보다 큰 경우
            if (poles[i] > list.get(list.size() - 1)) {
                // list 배열 마지막에 삽입
                list.add(poles[i]);
            } else {
                // list 배열에 적절한 위치에 삽입, 이분탐색 활용
                binarySearch(list, poles[i]);
            }
        }

        System.out.println(count_pole - list.size());
    }

    private static void binarySearch(List<Integer> list, int num) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        list.set(end, num);
    }
}