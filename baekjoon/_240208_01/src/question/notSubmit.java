package question;

import java.util.Scanner;

public class notSubmit {
    private static final int SUBMIT = 9999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] student = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                        14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                        25, 26, 27, 28, 29, 30
        };
        for (int i = 0; i < 28; i++) {
            int submit = scanner.nextInt();
            student[submit-1] = SUBMIT;
        }

        for (int n : student) {
            if(n != SUBMIT){
                System.out.println(n);
            }
        }
    }
}

