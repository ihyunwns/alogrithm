import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int dd = 100000;
    
    // 메모리 초과, 실패
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        
        make_one(x, 0);
        System.out.println(dd);
    }

    static void make_one(int x, int d) {
        if (x <= 1) {
            if (dd > d) {
                dd = d;
            }
        } else {
            d++;
            if (x % 3 == 0) {
                make_one(x/3, d);
            }
            if (x % 2 == 0) {
                make_one(x/2, d);
            }
            make_one(x-1, d);
        }
    }
}