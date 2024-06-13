package Bronze1;

import java.util.Objects;
import java.util.Scanner;

public class CMD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();
        String intitalize = sc.nextLine();
        String[] answer = intitalize.split("");
        for (int i = 0; i < n-1; i++) {
            String input = sc.nextLine();
            String[] compare = input.split("");

            for (int j = 0; j < intitalize.length(); j++) {
                if(!Objects.equals(answer[j], compare[j])){
                    answer[j] = "?";
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }
    }
}
