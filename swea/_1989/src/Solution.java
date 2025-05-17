import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int tc = 1; tc <= T; tc++) {
            String s = sc.nextLine();
            if (isPalindrome(s)) {
                System.out.println("#" + tc + " 1");
            } else {
                System.out.println("#" + tc + " 0");
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();

        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
