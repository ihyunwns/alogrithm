package question;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class smallerX {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int inputNum = scanner.nextInt();
        int x = scanner.nextInt();

        for (int i = 0; i < inputNum; i++) {
            int input = scanner.nextInt();
            if (input < x) {
                bw.write(input + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
