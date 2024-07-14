import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        private final int ID;
        private int distance;
        private List<Node> linkedNode;

        public Node(int x) {
            this.ID = x;
            this.distance = -1;
            this.linkedNode = new ArrayList<>();
        }

        public void addLinkedNode(Node node) {
            linkedNode.add(node);
        }

        public List<Node> getLinkedNode() {
            return linkedNode;
        }

        public void setDistance(int d) {
            distance = d;
        }
        public int getDistance() {
            return distance;
        }

        public int getID() {
            return ID;
        }
    }

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int id = 0;
        Node[][] maze = new Node[N][M];
        //미로 생성
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.split("")[j].equals("1")) {
                    maze[i][j] = new Node(id++);
                } else {
                    maze[i][j] = null;
                }
            }
        }

        Node n = BFS_Maze(makeGraph(maze));
        System.out.println(n.getDistance());

    }

    static Node[][] makeGraph(Node[][] maze) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] != null) {
                    // 인접 노드 연결
                    if (i - 1 >= 0 && maze[i-1][j] != null) {
                        maze[i][j].addLinkedNode( maze[i-1][j] );
                    }
                    if (i + 1 < N && maze[i+1][j] != null) {
                        maze[i][j].addLinkedNode( maze[i+1][j]);
                    }
                    if (j - 1 >= 0 && maze[i][j-1] != null) {
                        maze[i][j].addLinkedNode( maze[i][j-1]);
                    }
                    if (j + 1 < M && maze[i][j+1] != null) {
                        maze[i][j].addLinkedNode( maze[i][j+1]);
                    }
                }
            }
        }

        return maze;
    }

    static Node BFS_Maze(Node[][] maze) {
        Queue<Node> queue = new LinkedList<>();
        int d;
        Node node = maze[0][0];
        node.setDistance(1);

        queue.offer(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            d = node.getDistance() + 1;
            for (Node n : node.getLinkedNode()) {
                if (n.getDistance() == -1) {
                    queue.offer(n);
                    n.setDistance(d);
                }
            }
        }
        return maze[N-1][M-1];

    }
}