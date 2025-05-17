/*
* SWEA | 20019. 회문의 회문 | D3
* */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int tc=1; tc<=T; tc++) {
            String s = sc.nextLine();

            if (isPalindrome(s)) {
                // 처음 N-1/2 글자가 회문인지
                String firstHalf = s.substring(0, s.length() / 2);
                String lastHalf = s.substring((s.length() / 2) + 1);
                if (isPalindrome(firstHalf) && isPalindrome(lastHalf)) {
                    System.out.println("#" + tc + " YES");
                } else {
                    System.out.println("#" + tc + " NO");
                }
            } else {
                System.out.println("#"+tc+" NO");
            }
        }
    }

    static boolean isPalindrome(String s) {
        int length = s.length();

        // 회문인지 아닌지
        for(int i = 0; i < length / 2; i++) {
            if(s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
