package question;

import java.util.Scanner;

public class gugudan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int star = scanner.nextInt();

        for (int i = 0; i < star; i++) {
            for(int k = -1; k < i; k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
