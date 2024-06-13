package General;

import java.io.*;
import java.util.StringTokenizer;

public class GeneralSort {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Coordinate[] coords = new Coordinate[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coords[i] = new Coordinate(x, y);
        }

        Coordinate[] sortedC = new Coordinate[coords.length];
        bw = Coordinate.sort(coords); // 좌표 배열 정렬 메서드

        bw.flush();
        bw.close();

    }
}
