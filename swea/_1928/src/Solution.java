import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static final int[] LUT_base64 = new int[128]; // ASCII 범위

    static {
        // 초기화
        Arrays.fill(LUT_base64, -1);

        for (int i = 0; i < 26; i++) {
            LUT_base64['A' + i] = i;
        }

        for (int i = 0; i < 26; i++) {
            LUT_base64['a' + i] = 26 + i;
        }

        for (int i = 0; i < 10; i++) {
            LUT_base64['0' + i] = 52 + i;
        }

        LUT_base64['+'] = 62;
        LUT_base64['/'] = 63;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String encoded = br.readLine();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encoded.length(); i += 4) {
                int[] bin;
                for (int j = 0; j < 4; j++) {
                    int num = LUT_base64[encoded.charAt(i+j)];
                    bin = decTobin(num);
                    sb.append(binToStr(bin));
                }
            }

            StringBuilder sb2= new StringBuilder();
            for(int i = 0; i < sb.length(); i+=8){
                int[] bin = new int[8];
                for (int j = 0; j < 8; j++) {
                    bin[j] = Integer.parseInt(String.valueOf(sb.charAt(i+j)));
                }
                char decoded = (char)binToDec(bin);
                sb2.append(decoded);
            }

            System.out.println("#" + tc + " " + sb2);
        }
    }

    private static int[] decTobin(int dec) {
        int[] bin = new int[6];

        for(int i = 0; dec != 0; i++){
            bin[bin.length-1-i] = dec % 2;
            dec /= 2;
        }
        return bin;
    }

    private static int binToDec(int[] bin) {
        int dec = 0;
        for (int i = 0; i < bin.length; i++) {
            dec += (int) (bin[i] * Math.pow(2, bin.length - 1 - i));
        }
        return dec;
    }

    private static String binToStr(int[] bin) {

        StringBuilder sb = new StringBuilder();
        for (int j : bin) {
            sb.append(j);
        }

        return sb.toString();
    }
}
