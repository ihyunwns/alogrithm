import java.util.*;

public class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1" })));
    }
}

class Solution {
    static boolean[][] visited;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        List<Integer> answerList = new ArrayList<>();

        visited = new boolean[maps.length][maps[0].length()];
        for (boolean[] v : visited) {
            Arrays.fill(v, false);
        }

        String[][] island = makeIsland(maps);
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length; j++) {
                //땅이 있고 방문하지 않은 땅이라면
                if (!island[i][j].equals("X") && !visited[i][j]) {
                    answerList.add(DFS(island, i, j, 0));
                }
            }
        }
        Collections.sort(answerList);

        if (answerList.isEmpty()) {
            return new int[]{-1};
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private String[][] makeIsland(String[] maps) {
        String[][] island = new String[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                island[i][j] = maps[i].split("")[j];
            }
        }
        return island;
    }

    private int DFS(String[][] island, int x, int y, int count) {
        count += Integer.parseInt(island[x][y]);

        visited[x][y] = true;
        // 상하좌우 탐색 시작
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isInBounds(nx, ny, island)) {
                if (!island[nx][ny].equals("X") && !visited[nx][ny]) {
                    count = DFS(island, nx, ny, count);
                }
            }
        }

        return count;
    }

    private boolean isInBounds(int x, int y, String[][] island) {
        return x >= 0 && y >= 0 && x < island.length && y < island[0].length;
    }
}