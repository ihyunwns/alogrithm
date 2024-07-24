import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    private final int x;
    private final int y;
    private final State state;

    // -x, +x, -y, +y 접근에 대한 visited
    private boolean[] visited = new boolean[]{false, false, false, false};

    public Node(int x, int y, State state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public void addVisited(int index) {
        this.visited[index] = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public State getState() {
        return state;
    }

}
public class Main {
    static int solution(String[] board) {

        int i;
        for (i = 0; i < board.length; i++) {
            if (board[i] == null) {
                break;
            }
        }
        Node[][] nBoard = new Node[i][board[0].length()];
        Node R = null;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < board[0].length(); k++) {
                switch (board[j].split("")[k]) {
                    case "R" -> {
                        nBoard[j][k] = new Node(j, k, State.ROBOT);
                        R = nBoard[j][k];
                    }
                    case "D" -> nBoard[j][k] = new Node(j, k, State.DETERRENT);
                    case "G" -> {
                        nBoard[j][k] = new Node(j, k, State.GOAL);
                    }
                    default -> nBoard[j][k] = new Node(j, k, State.ROAD);
                }
            }
        }

        return bfs_ricochet(nBoard, R);

    }

    static int bfs_ricochet(Node[][] board, Node robot) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{robot.getX(), robot.getY(), 0});

        int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int steps = current[2];

            for (int j = 0; j < 4; j++) {
                int nx = x;
                int ny = y;
                int isMove = 0;

                while (isInBounds(nx + dx[j], ny + dy[j], board) && board[nx + dx[j]][ny + dy[j]].getState() != State.DETERRENT) {
                    isMove++;
                    nx += dx[j];
                    ny += dy[j];
                }

                if (isMove > 0) {
                    if (board[nx][ny].getState() == State.GOAL) {
                        return steps + 1;
                    }
                    if (!board[nx][ny].getVisited()[j]) {
                        board[nx][ny].addVisited(j);
                        queue.offer(new int[]{nx, ny, steps+1});
                    }
                }
            }
        }

        return -1;
    }
    static boolean isInBounds(int x, int y, Node[][] board) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }

    public static void main(String[] args) throws IOException {
        String[] board = new String[100];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeat; i++) {
            board[i] = br.readLine();
        }

        System.out.println(solution(board));
    }

}

