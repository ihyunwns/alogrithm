import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        if (input % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}