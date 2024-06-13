package question;

import java.util.Scanner;

public class repeatN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        for (int i = 1; i < a+1; i++) {
            System.out.println(i);
        }
    }
}
