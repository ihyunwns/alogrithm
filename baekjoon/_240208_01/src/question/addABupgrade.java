package question;

import java.util.Scanner;

public class addABupgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (true) {
            if(repeat-- == 0){
                break;
            }
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);

        }
    }
}
