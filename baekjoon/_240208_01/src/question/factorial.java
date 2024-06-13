package question;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int result = 1;
        for (int i = 1; i < a+1; i++) {
            result = result * i;
        }
        System.out.println(result);
    }
}
