package question;

import java.util.Scanner;

public class quadrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a * b > 0) {
            if (a > 0) {
                System.out.println("1");
            } else {
                System.out.println("3");
            }
        } else {
            if (a > 0) {
                System.out.println("4");
            } else {
                System.out.println("2");
            }
        }
    }
}
