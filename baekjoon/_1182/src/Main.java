import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int count = 0;
    static int solution;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int c = Integer.parseInt(input[0]);
        solution = Integer.parseInt(input[1]);

        String lines = br.readLine();
        int[] arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = Integer.parseInt(lines.split(" ")[i]);
        }

        solve(arr, 0, new int[c], true, 0);
        solve(arr, 0, new int[c], false, 0);

        System.out.println(count);
    }

    static void solve(int[] sets, int node, int[] visited, boolean isVisit, int nonVisitCount) {
        // 먼저 종료 조건 체크
        if (node >= sets.length) {
            return;
        }

        // 방문한 경우
        if (isVisit) {
            // 방문한 노드 배열에 추가
            visited[node] = sets[node];
        } else {
            visited[node] = -999999999;
            nonVisitCount++;
        }

        if(node == sets.length-1){
            // 공집합 제외
            if(nonVisitCount == sets.length) return;

            int sum = 0;
            for (int j : visited) {
                if (j != -999999999) sum += j;
            }

            if (sum == solution) {
                count++;
            }
        }

        // 방문하는 경우
        solve(sets,node + 1, visited.clone(), true, nonVisitCount);

        // 방문하지 않는 경우
        solve(sets,node + 1, visited.clone(), false, nonVisitCount);
    }
}