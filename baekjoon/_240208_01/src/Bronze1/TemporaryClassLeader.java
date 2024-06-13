package Bronze1;

import java.util.Scanner;

public class TemporaryClassLeader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentNum = scanner.nextInt();

        scanner.nextLine();
        int[][] student = new int[studentNum][5];
        int[][] classMap = new int[studentNum][5];

        for (int i = 0; i < studentNum; i++) {
            String classNum = scanner.nextLine();
            for (int k = 0; k < 5; k++) {
                student[i][k] = Integer.parseInt(classNum.split(" ")[k]);
            }
        }

        for (int grade = 0; grade < 5; grade++) {
            int currentStudentclass;
            for (int nStudent = 0; nStudent < studentNum; nStudent++) {
                currentStudentclass = student[nStudent][grade];
                for (int i = 0; i < studentNum; i++) {
                    if( currentStudentclass == student[i][grade]){
                        classMap[nStudent][grade]++;
                    }
                }
            }
        }

        int max = 0;
        int temporaryLeader = 0;
        for (int nStudent = 0; nStudent < studentNum; nStudent++) {
            int sum = 0;
            for (int grade = 0; grade < 5; grade++) {
                sum += classMap[nStudent][grade];
            }
            if (sum > max) {
                max = sum;
                temporaryLeader = nStudent+1;
            }
        }

        System.out.println(temporaryLeader);
    }
}