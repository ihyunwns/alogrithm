package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class verifications {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        Calculate c = new Calculate();
        System.out.println(c.calculate(stringTokenizer));

    }
}

class Calculate {
    int result = 0;
    int calculate(StringTokenizer st) {
        while (st.hasMoreTokens()) {
            result += (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
        }

        return result % 10;
    }
}