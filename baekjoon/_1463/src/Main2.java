import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {

    static class Node {
        int x;
        int floor;

        public Node(int x, int floor) {
            this.x = x;
            this.floor = floor;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        bfs_make(new Node(x, 0));

    }

    static void bfs_make(Node x) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(x);
        Node n = null;

        while (!queue.isEmpty()) {
            n = queue.poll();
            if (n.x <= 1) {
                break;
            }
            if (n.x % 3 == 0) {
                queue.offer(new Node(n.x / 3, n.floor+1));
            }
            if (n.x % 2 == 0) {
                queue.offer(new Node(n.x / 2, n.floor+1));
            }
            queue.offer(new Node(n.x - 1, n.floor+1 ));
        }
        System.out.println(n.floor);
    }
}
