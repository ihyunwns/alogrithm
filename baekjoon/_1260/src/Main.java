import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int node = Integer.parseInt(st.nextToken());
        int link = Integer.parseInt(st.nextToken());
        int nodeIndex = Integer.parseInt(st.nextToken());

        List<String> inputGraph = new ArrayList<>();
        for (int i = 0; i < link; i++) {
            inputGraph.add(br.readLine());
        }

        int[][] graph = graphMaker(inputGraph, node, link);

        visited = new boolean[node + 1];
        DFS(graph, nodeIndex);
        System.out.println("");
        visited = new boolean[node + 1];
        BFS(graph, nodeIndex);
    }

    public static void DFS(int[][] graph, int nodeIndex) {
        visited[nodeIndex] = true;
        System.out.print( nodeIndex + " ");

        for (int node : graph[nodeIndex]) {
            // 방문 안한 노드라면
            if (!visited[node]) {
                DFS(graph, node);
            }
        }
    }

    public static void BFS(int[][] graph, int nodeIndex) {
        Queue<Integer> queue = new LinkedList<>();
        // 탐색 시작 노드 큐에 삽입 후 방문 처리
        queue.offer(nodeIndex);
        visited[nodeIndex] = true;

        // queue에서 빼내고 방문한 노드의 아직 방문 안한 노드를 다 queue에 삽입함
        while (!queue.isEmpty()) {
            //방문한 노드
            int node = queue.poll();
            System.out.print( node + " ");

            //방문한 노드의 인접 노드 탐색
            for (int linkedNode : graph[node]) {
                // 방문하지 않았다면
                if (!visited[linkedNode]) {
                    // queue에 인접 노드를 삽입 후 방문 처리
                    queue.offer(linkedNode);
                    visited[linkedNode] = true;
                }

            }
        }
    }

    public static int[][] graphMaker(List<String> input, int node, int link) {
        List<Integer>[] graph = new ArrayList[node+1];

        for (int i = 0; i < node + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (String inputNode : input) {
            StringTokenizer st = new StringTokenizer(inputNode);
            int ln = Integer.parseInt(st.nextToken());
            int rn = Integer.parseInt(st.nextToken());

            graph[ln].add(rn);
            graph[rn].add(ln);
        }

        int[][] rGraph = new int[node+1][link];
        for (int i = 0; i < node + 1; i++) {
            rGraph[i] = graph[i].stream().mapToInt(Integer::intValue).sorted().toArray();
        }

        return rGraph;
    }
}
