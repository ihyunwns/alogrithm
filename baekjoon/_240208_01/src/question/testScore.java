package question;

import java.util.Scanner;

public class testScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        if( a > 89 ){
            System.out.println("A");
        } else if (a > 79) {
            System.out.println("B");
        } else if (a > 69) {
            System.out.println("C");
        } else if (a > 59) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        // 자바 11에선 안되나봄
//        switch (a / 10) {
//            case 9, 10 -> System.out.println("A");
//            case 8 -> System.out.println("B");
//            case 7 -> System.out.println("C");
//            case 6 -> System.out.println("D");
//            default -> System.out.println("F");
//        }
    }
}
