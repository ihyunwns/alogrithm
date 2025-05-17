import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int tc = 1; tc <= T; tc++) {
            String s = sc.nextLine();
            // 기준 문자
            char base_code = '0';
            int change_count = 0;
            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != base_code) {
                    base_code = s.charAt(i);
                    change_count++;
                }
            }

            System.out.println("#" + tc + " " + change_count);
        }
    }
}
