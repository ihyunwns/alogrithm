package ComparableImpl;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Coordinate> list = new ArrayList<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Coordinate(x, y));
        }

        Collections.sort(list);

        for (Coordinate coord : list) {
            bw.write(coord.getX() + " " + coord.getY() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
