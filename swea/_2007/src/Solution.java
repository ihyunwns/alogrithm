import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int tc = 1; tc <= T; tc++) {
            String pattern = findConsecutivePattern(sc.nextLine());
            System.out.println("#" + tc + " " + Objects.requireNonNullElse(pattern, "NONE"));
        }
    }

    public static String findConsecutivePattern(String s) {

        int length = s.length();

        // 패턴은 문자의 길이/2 보다 클 수 없음
        // p_len : 패턴 길이
        for(int p_len = 1; p_len <= length / 2; p_len++) {
            String pattern = s.substring(0, p_len);
            int repeat_pattern = 0;
            boolean is_pattern = true;

            for(int j = p_len; j < length; j += p_len) {
                if (j + p_len > length) {
                    break;
                }

                String sub = s.substring(j, j + p_len);

                if (pattern.equals(sub)) {
                    repeat_pattern++;
                } else {
                    is_pattern = false;
                    break;
                }
            }

            if (is_pattern && repeat_pattern >= 2) {
                return pattern;
            }
        }
        return null;
    }


}
