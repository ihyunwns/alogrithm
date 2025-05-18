import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Node {
        int swap_cnt;
        // int[] 로 하면 배열의 참조값을 비교하기 때문에 실제로는 같은 숫자 배열이라도 다른 것으로 인식되서 Set 사용 의미가 X
        // 따라서 String 으로 변경
        String number;

        public Node(String number, int swap_cnt) {
            this.number = number;
            this.swap_cnt = swap_cnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String input = br.readLine();

            String winning = input.split(" ")[0];
            int exchange_cnt = Integer.parseInt(input.split(" ")[1]);

            Queue<Node> queue = new LinkedList<>();
            Set<String>[] visited = new HashSet[exchange_cnt+1];
            for (int i = 0; i < visited.length; i++) {
                visited[i] = new HashSet<>();
            }

            int max = 0;
            queue.offer(new Node(winning, 0));
            while(!queue.isEmpty()) {

                Node cur = queue.poll();

                // exchange_cnt 와 같은 노드라면 이제 부터 max 값 갱신
                if(cur.swap_cnt == exchange_cnt) {
                    int cur_num = Integer.parseInt(cur.number);
                    if(cur_num > max) {
                        max = cur_num;
                    }
                    continue;
                }
                // 자리 swap 하면서 방문 처리, visited 에서 먼저 검사
                // 없으면 queue.offer 및 visited에 add
                int length = cur.number.length();
                for (int i = 0; i < length; i++) {
                    for (int j = i + 1; j < length; j++) {
                        char[] next = cur.number.toCharArray();
                        char temp = next[i];
                        next[i] = next[j];
                        next[j] = temp;

                        String nextNumber = String.valueOf(next);

                        // 해당 작업에서 분기되는 다음 숫자들을 큐에 적재하는 작업 따라서 cnt+1
                        if (!visited[cur.swap_cnt + 1].contains(nextNumber)) {
                            visited[cur.swap_cnt + 1].add(nextNumber);
                            queue.offer(new Node(nextNumber, cur.swap_cnt + 1));
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + max);

            /*
            *           x
            *       x  x  x  x   depth 1 > swap 횟수
            *   x x x x x x x x .... depth 2
            *
            * 일 때 dfs는 depth 2 찍었다가 다시 depth 1으로 오고 해서 비효율 적
            * BFS로 depth1의 swap을 마치고 depth2 의 최대값 비교를 하는게 더 효율적 일 듯
            * 이때 같은 깊이의 숫자는 중복이 안되도록 visited[depth] 로 중복 관리가 중요할 듯, Set 자료구조 활용
            * */

        }
    }
}
