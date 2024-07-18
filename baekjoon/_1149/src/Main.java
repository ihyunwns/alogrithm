import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int house = Integer.parseInt(br.readLine());

        int[] R = new int[house+1]; int[] G = new int[house+1]; int[] B = new int[house+1];
        int[] dR = new int[house+1]; int[] dG = new int[house+1]; int[] dB = new int[house+1];

        for (int i = 1; i <= house; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        R[0] = 0; G[0] = 0; B[0] = 0;
        dR[0] = 0; dG[0] = 0; dB[0] = 0;
        // 공부 필요 해설 봤음 .. ㅜㅜ
        for (int i = 1; i <= house; i++) {
            dR[i] = Math.min(dG[i - 1], dB[i - 1]) + R[i];
            dG[i] = Math.min(dR[i - 1], dB[i - 1]) + G[i];
            dB[i] = Math.min(dR[i - 1], dG[i - 1]) + B[i];
        }

        System.out.println( Math.min(Math.min(dR[house], dG[house]), dB[house]) );

    }
}