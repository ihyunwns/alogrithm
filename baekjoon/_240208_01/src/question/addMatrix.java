package question;

import java.util.Scanner;

public class addMatrix {
    public static void main(String[] args) {
        A aa = new A();
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        System.out.println(aa.aaa(a, b));
    }
}
class A {
    long aaa(long a, long b) {
        return (a + b) * (a - b);
    }
}


