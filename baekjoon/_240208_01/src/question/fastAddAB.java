package question;

import java.io.*;
import java.util.StringTokenizer;

public class fastAddAB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        int a, b;
        while (true) {
            if(repeat-- == 0){
                break;
            }
            StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write(a + b + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
