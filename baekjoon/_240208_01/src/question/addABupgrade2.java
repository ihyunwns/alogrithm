package question;

import java.util.Scanner;

public class addABupgrade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 & b == 0) {
                break;
            } else {
                System.out.println(a+b);
            }
        }
    }
}
